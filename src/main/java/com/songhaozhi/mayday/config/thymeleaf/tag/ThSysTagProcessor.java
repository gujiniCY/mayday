package com.songhaozhi.mayday.config.thymeleaf.tag;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

import com.songhaozhi.mayday.model.dto.MaydayConst;

/**
 * @author : 宋浩志
 * @createDate : 2018年12月17日
 */
public class ThSysTagProcessor extends AbstractAttributeTagProcessor {
	private static final String TEXT_ATTRIBUTE = "text";
	private static final int PRECEDENCE = 10000;

	/*
	 * templateMode: 模板模式，这里使用HTML模板。 dialectPrefix:
	 * 标签前缀。即xxx:text中的xxx。在此例子中prefix为masking。
	 * elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。
	 * prefixElementName: 标签名是否要求前缀。 attributeName: 自定义标签属性名。这里为text。
	 * prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即thSys:
	 * text。 precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
	 * removeAttribute：标签处理后是否移除自定义属性。
	 */
	public ThSysTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, TEXT_ATTRIBUTE, true, PRECEDENCE, true);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
			String attributeValue, IElementTagStructureHandler structureHandler) {
		final IEngineConfiguration configuration = context.getConfiguration();
		final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
		final IStandardExpression expression = parser.parseExpression(context, attributeValue);
		final String title = (String) expression.execute(context);
		structureHandler.setBody(title + " - " + MaydayConst.OPTIONS.get("blog_name"), false);
	}

}
