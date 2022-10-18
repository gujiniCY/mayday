package com.songhaozhi.mayday.exception;

import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 全局捕获异常
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    protected static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Spirng 非法参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult validException(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String result = bindingResult.getFieldErrors().get(0).getDefaultMessage();
        log.error("BindException,{}", result);
        return JsonResult.fail(result);
    }

    /**
     * javax.validation 非法参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<ConstraintViolation<?>> list = new ArrayList<>(constraintViolations);
        String result = list.get(0).getMessage();
        log.error("ConstraintViolationException,{}", result);
        return JsonResult.fail(result);
    }

    /**
     * javax.validation 非法参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String result = bindingResult.getFieldErrors().get(0).getDefaultMessage();
        log.error("MethodArgumentNotValidException,{}", result);
        return JsonResult.fail(result);
    }

    /**
     * 数据库执行异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleDataAccessException(DataAccessException e) {
        log.error("Catch an DataAccessException:", e);
        return JsonResult.result(MaydayEnums.DATEBASE_EXECUTION_EXCEPTION);
    }

    /**
     * HTTP解析请求参数异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("httpMessageNotReadableException:", exception);
        return JsonResult.result(MaydayEnums.PARAMETER_EXCEPTION);
    }

    /**
     * HTTP
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMediaTypeException.class)
    @ResponseStatus(HttpStatus.OK)
    public JsonResult httpMediaTypeException(HttpMediaTypeException exception) {
        log.error("httpMediaTypeException:", exception);
        return JsonResult.result(MaydayEnums.PARAMETER_EXCEPTION);
    }


    /**
     * HTTP请求方式错误
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("httpRequestMethodNotSupportedException:", exception);
        return JsonResult.result(MaydayEnums.HTTP_REQUEST_METHOD_NOT_SUPPORTED);
    }

    /**
     * 运行时异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult runtimeExceptionHandler(RuntimeException exception) {
        log.error("exception:", exception);
        return JsonResult.fail(exception.getMessage());
    }

    /**
     * 默认的异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult exceptionHandler(Exception exception) {
        log.error("exception:", exception);
        return JsonResult.result(MaydayEnums.ERROR);
    }

}
