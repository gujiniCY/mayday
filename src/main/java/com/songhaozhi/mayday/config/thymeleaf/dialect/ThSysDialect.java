package com.songhaozhi.mayday.config.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import com.songhaozhi.mayday.config.thymeleaf.tag.ThSysTagProcessor;

/**
 * 系统方言
 * 
 * @author : 宋浩志
 * @createDate : 2018年12月4日
 * 
 */
public class ThSysDialect extends AbstractProcessorDialect {
	// 定义方言名称
	private static final String DIALECT_NAME = "Sys Dialect";

	public ThSysDialect() {
		// 设置自定义方言与"方言处理器"优先级相同
		super(DIALECT_NAME, "thSys", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new ThSysTagProcessor(dialectPrefix));
		processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
		return processors;
	}

}
