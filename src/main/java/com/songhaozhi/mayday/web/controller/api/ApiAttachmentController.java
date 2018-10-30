package com.songhaozhi.mayday.web.controller.api;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月30日 下午2:28:54
*/

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.AttachmentService;
import com.songhaozhi.mayday.web.controller.admin.BaseController;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@RequestMapping(value = "/api/admin/attachment")
public class ApiAttachmentController extends BaseController {
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * 上传附件
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	public JsonResult upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		return uploadAttachment(file, request);
	}

	/**
	 * 删除附件
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "deleteAttachment")
	public JsonResult deleteAttachment(@RequestParam(value = "id") int id, HttpServletRequest request) {
		Attachment attachment = attachmentService.findById(id);
		try {
			// 获取用户目录
			String userPath = System.getProperties().getProperty("user.home") + "/mayday";
			// 获取文件路径
			String picturePath = attachment.getPicturePath();
			String pictureSmallPath = attachment.getPictureSmallPath();
			File picturePathFile = new File(new StringBuffer(userPath).append(picturePath).toString());
			File pictureSmallPathFile = new File(new StringBuffer(userPath).append(pictureSmallPath).toString());
			if (picturePathFile.isFile() && picturePathFile.exists()) {
				if (pictureSmallPathFile.delete() && picturePathFile.delete()) {
					attachmentService.deleteAttachment(id);
					log.info("删除文件" + attachment.getPictureName() + "成功");
					// 添加日志
					logService.save(new Log(LogConstant.DELETE_ATTACHMENT, LogConstant.DELETE_SUCCESS,
							ServletUtil.getClientIP(request), DateUtil.date()));
				} else {
					log.error("删除文件" + attachment.getPictureName() + "失败");
					return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(),
							MaydayEnums.OPERATION_ERROR.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("删除文件" + attachment.getPictureName() + "失败");
			return new JsonResult(MaydayEnums.ERROR.isFlag(), MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.OPERATION_SUCCESS.isFlag(), MaydayEnums.OPERATION_SUCCESS.getMessage());
	}

	/**
	 * 上传功能
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	public JsonResult uploadAttachment(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				// 获取用户目录
				String userPath = System.getProperties().getProperty("user.home") + "/mayday";
				// 上传路径
				StringBuffer sb = new StringBuffer("upload/");
				// 获取时间，以年月创建目录
				Date date = DateUtil.date();
				sb.append(DateUtil.thisYear()).append("/").append(DateUtil.thisMonth() + 1).append("/");
				File mediaPath = new File(userPath, sb.toString());
				// 如果没有该目录则创建
				if (!mediaPath.exists()) {
					mediaPath.mkdirs();
				}
				System.out.println("路径++++++" + mediaPath);
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				// 生成文件名称
				String nameSuffix = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."))
						.replaceAll(" ", "_").replaceAll(",", "") + format.format(DateUtil.date())
						+ new Random().nextInt(1000);
				// 文件后缀
				String fileSuffix = file.getOriginalFilename()
						.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				// 上传文件名
				String fileName = nameSuffix + "." + fileSuffix;
				file.transferTo(new File(mediaPath.toString(), fileName));
				// 压缩图片
				Thumbnails.of(new StringBuffer(mediaPath.getAbsolutePath()).append("/").append(fileName).toString())
						.size(256, 256).keepAspectRatio(false).toFile(new StringBuffer(mediaPath.getAbsolutePath())
								.append("/").append(nameSuffix).append("_small.").append(fileSuffix).toString());
				// 添加数据库
				Attachment attachment = new Attachment();
				attachment.setPictureName(fileName);
				attachment.setPicturePath(new StringBuffer("/upload/").append(DateUtil.thisYear()).append("/")
						.append(DateUtil.thisMonth() + 1).append("/").append(fileName).toString());
				attachment.setPictureType(file.getContentType());
				attachment.setPictureCreateDate(date);
				attachment.setPictureSuffix(new StringBuffer().append(".").append(fileSuffix).toString());
				attachment.setPictureSmallPath(new StringBuffer("/upload/").append(DateUtil.thisYear()).append("/")
						.append(DateUtil.thisMonth() + 1).append("/").append(nameSuffix).append("_small.")
						.append(fileSuffix).toString());
				attachmentService.save(attachment);
				// 添加日志
				logService.save(new Log(LogConstant.UPLOAD_ATTACHMENT, LogConstant.UPLOAD_SUCCESS,
						ServletUtil.getClientIP(request), DateUtil.date()));
			} catch (Exception e) {
				e.printStackTrace();
				log.error("上传附件错误" + e.getMessage());
				return new JsonResult(false, "系统未知错误");
			}
		} else {
			return new JsonResult(false, "文件不能为空");
		}
		return new JsonResult(true, "上传成功");
	}

}