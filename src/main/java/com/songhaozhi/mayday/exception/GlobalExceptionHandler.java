package com.songhaozhi.mayday.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.web.controller.BaseController;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月7日 下午2:44:56
*/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends BaseController {
	/**
	 * 系统异常处理，比如：404,500
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	log.error("",e);
    	JsonResult json=new JsonResult();
    	json.setMsg(e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
             json.setCode("404");
        } else {
        	   json.setCode("500");
        }
        json.setFlag(false);
        return json;
    }
}
