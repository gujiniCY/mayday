package com.songhaozhi.mayday.web.controller.admin;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.songhaozhi.mayday.model.domain.Attachment;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.service.AttachmentService;

import cn.hutool.core.date.DateUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年9月7日 上午10:35:55
 */
@RequestMapping(value="/admin/attachment")
@Controller
public class AttachmentController {
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping
	public String attachment() {
		return "/admin/admin_attachment";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public JsonResult upload(@RequestParam(value="file") MultipartFile file,HttpServletRequest request) {
		return uploadAttachment(file,request);
	}
	
	
	public JsonResult uploadAttachment(@RequestParam(value="file") MultipartFile file,HttpServletRequest request) {
		if(!file.isEmpty()) {
			try {
				//上传文件名
				String fileName=file.getOriginalFilename();
				//获取项目真实路径src/main/resources
				File path = new File(ResourceUtils.getURL("classpath:").getPath());
				// 文件的扩展名
				String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
				//上传路径
				StringBuffer sb=new StringBuffer("upload/");
				//获取时间，以年月创建目录
				Date date = DateUtil.date();
				sb.append(DateUtil.year(date)).append("/").append(DateUtil.month(date)).append("/");
				File File = new File(path.getAbsolutePath(),sb.toString());
				//如果没有该目录则创建
		 		if(!File.exists()){
				File.mkdirs();
		 		}
		 		file.transferTo(new File(File.toString(),fileName));
		 		//压缩图片
		 		//Thumbnails.of();
		 		//添加数据库
		 		Attachment attachment=new Attachment();
		 		attachment.setPictureName(fileName);
		 		attachment.setPicturePath(File.getAbsolutePath()+fileName);
		 		attachment.setPictureType(file.getContentType());
		 		attachment.setPictureCreateDate(date);
		 		attachment.setPictureSuffix(extensionName);
		 		attachmentService.save(attachment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return new JsonResult(false,MaydayEnums.OPERATION_ERROR.getCode(),"文件不能为空");
		}
		return new JsonResult(false,MaydayEnums.OPERATION_SUCCESS.getCode(),"上传成功");
	}

}
