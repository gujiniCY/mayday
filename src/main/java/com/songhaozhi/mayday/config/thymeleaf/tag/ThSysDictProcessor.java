package com.songhaozhi.mayday.config.thymeleaf.tag;

import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.songhaozhi.mayday.model.dto.MaydayConst;

/**
* @author 宋浩志
* @createDate 创建时间：2018年12月4日 下午9:20:14
* 
*/
public class ThSysDictProcessor extends AbstractElementTagProcessor{
	//标签名
	private static final String TITLE_NAME="title";
	//优先级
	private static final int PRECEDENCE=10000;
	
	
	public ThSysDictProcessor(String dialectPrefix) {
		super(
				//此处理器仅应用于HTML模式
				TemplateMode.HTML, 
				//要应用于名称的匹配前缀
				dialectPrefix, 
				//标签名称：匹配此名称的特定标签
				TITLE_NAME, 
				//将标签前缀应用于标签名称
				false,
				//无属性名称:将通过标签名称匹配
				null, 
				//没有要应用于属性名称的前缀
				false, 
				//优先级
				PRECEDENCE);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
		Map<String, String> map=MaydayConst.options;
		structureHandler.setBody( map.get("blog_name"), false);
	}

}
