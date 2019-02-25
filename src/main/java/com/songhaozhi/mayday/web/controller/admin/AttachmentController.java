package com.songhaozhi.mayday.web.controller.admin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.domain.Log;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.AttachmentService;
import com.songhaozhi.mayday.util.MaydayUtil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import net.coobird.thumbnailator.Thumbnails;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月7日 附件
 */
@RequestMapping(value = "/admin/attachment")
@Controller
public class AttachmentController extends BaseController {
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * 跳转附件页面并显示所有图片
	 * 
	 * @return
	 */
	@GetMapping
	public String attachment(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "18") int limit) {
		PageInfo<Attachment> info = attachmentService.getAttachment(page, limit);
		model.addAttribute("info", info);
		return "admin/admin_attachment";
	}

	/**
	 * 上传附件
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/upload")
	@ResponseBody
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
	@ResponseBody
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
				// 保存目录
				StringBuffer hold = new StringBuffer("upload/");
				// 获取时间，以年月创建目录
				Date date = DateUtil.date();
				hold.append(DateUtil.thisYear()).append("/").append(DateUtil.thisMonth() + 1).append("/");
				File mediaPath = new File(userPath, hold.toString());
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
				// 上传文件名加后缀
				String fileName = nameSuffix + "." + fileSuffix;

				// 转存文件
				file.transferTo(new File(mediaPath.toString(), fileName));

				// 原图片路径
				StringBuffer originalPath = new StringBuffer();
				originalPath.append(mediaPath.getAbsolutePath()).append("/").append(fileName);
				// 压缩图片路径
				StringBuffer compressPath = new StringBuffer();
				compressPath.append(mediaPath.getAbsolutePath()).append("/").append(nameSuffix).append("_small.")
						.append(fileSuffix);
				// 压缩图片
				Thumbnails.of(originalPath.toString()).size(256, 256).keepAspectRatio(false).toFile(compressPath.toString());
				// 原图数据库路径
				StringBuffer originalDataPath = new StringBuffer();
				originalDataPath.append("/").append(hold).append(fileName);
				// 压缩图数据库路径
				StringBuffer compressDataPath = new StringBuffer();
				compressDataPath.append("/").append(hold).append(nameSuffix).append("_small.").append(fileSuffix);
				// 添加数据库
				Attachment attachment = new Attachment();
				attachment.setPictureName(fileName);
				attachment.setPicturePath(originalDataPath.toString());
				attachment.setPictureType(file.getContentType());
				attachment.setPictureCreateDate(date);
				attachment.setPictureSuffix(new StringBuffer().append(".").append(fileSuffix).toString());
				attachment.setPictureSmallPath(compressDataPath.toString());
				attachment.setPictureWh(MaydayUtil.getImageWh(new File(mediaPath.toString() + "/" + fileName)));
				attachment
						.setPictureSize(MaydayUtil.parseSize(new File(mediaPath.toString() + "/" + fileName).length()));
				attachmentService.save(attachment);
				// 添加日志
				logService.save(new Log(LogConstant.UPLOAD_ATTACHMENT, LogConstant.UPLOAD_SUCCESS,
						ServletUtil.getClientIP(request), DateUtil.date()));
			} catch (Exception e) {
				log.error("上传附件错误" + e.getMessage());
				return new JsonResult(false, "系统未知错误");
			}
		} else {
			return new JsonResult(false, "文件不能为空");
		}
		return new JsonResult(true, "上传成功");
	}

	/**
	 * 附件详情
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "viewDetails/{id}")
	public String viewDetails(Model model, @PathVariable int id) {
		Attachment attachment = attachmentService.findById(id);
		model.addAttribute("attachment", attachment);
		return "admin/part/view_details";
	}

}
