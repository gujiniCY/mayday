package com.songhaozhi.mayday.util;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.dto.MaydayConst;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author : 宋浩志
 * @createDate : 2018年12月6日
 */
@Component
public class Commons {

	private static final String[] ICONS = { "bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code",
			"bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock" };

	/**
	 * 显示文章图标
	 *
	 * @param id
	 * @return
	 */
	public static String show_icon(int id) {
		return ICONS[id % ICONS.length];
	}

	/**
	 * 显示分类
	 * 
	 * @param categorysUrl
	 *            分类URL
	 * @param categorysName
	 *            分类名称
	 * @return
	 */
	public static String show_categories(String categorysUrl, String categorysName) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (StrUtil.isNotBlank(categorysUrl)) {
			String[] categoryUrl = categorysUrl.split(",");
			String[] categoryName = categorysName.split(",");
			int i = 0;
			for (String url : categoryUrl) {
				sb.append("<a href=\"/category/" + URLEncoder.encode(url, "UTF-8") + "\">" + categoryName[i] + "</a>");
				i++;
			}
		}
		return sb.toString();
	}

	/**
	 * 显示标签
	 * 
	 * @param categorysUrl
	 * @param categorysName
	 * @return
	 * @throws Exception
	 */
	public static String show_tags(String tagsUrl, String tagsName) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (StrUtil.isNotBlank(tagsUrl)) {
			String[] tagUrl = tagsUrl.split(",");
			String[] tagName = tagsName.split(",");
			int i = 0;
			for (String url : tagUrl) {
				sb.append("<a href=\"/tags/" + URLEncoder.encode(url, "UTF-8") + "\">" + tagName[i] + "</a>");
				i++;
			}
		}
		return sb.toString();
	}

	/**
	 * 判断分页中是否有数据
	 *
	 * @param paginator
	 * @return
	 */
	public static boolean is_empty(PageInfo paginator) {
		return paginator == null || (paginator.getList() == null) || (paginator.getList().size() == 0);
	}
	/**
	 * 获取年份
	 * @return 年份
	 */
	public static int getYear() {
		return DateUtil.year(new Date());
	}
	/**
	 * pinghsu主题 获取社交链接
	 * @return
	 */
	public static Map<String,String> social(){
		final String prefix = "pinghsu_";
		Map<String,String> map=new HashMap<>();
		map.put("weibo", MaydayConst.OPTIONS.get(prefix+"weibo"));
		map.put("zhihu", MaydayConst.OPTIONS.get(prefix+"zhihu"));
		map.put("github", MaydayConst.OPTIONS.get(prefix+"github"));
		map.put("twitter", MaydayConst.OPTIONS.get(prefix+"twitter"));
		if(StrUtil.isNotEmpty(MaydayConst.OPTIONS.get(prefix+"qq"))) {
			map.put("qq", "http://wpa.qq.com/msgrd?v=3&uin="+MaydayConst.OPTIONS.get(prefix+"qq")+"&site=qq&menu=yes");
		}
		if(StrUtil.isNotEmpty(MaydayConst.OPTIONS.get(prefix+"email"))) {
			map.put("email", "mailto:"+MaydayConst.OPTIONS.get(prefix+"email"));
		}
		if("rss_open".equals(MaydayConst.OPTIONS.get(prefix+"rss"))) {
				map.put("rss", MaydayConst.OPTIONS.get("blog_url")+"/index.xml");
		}
		return map;
	}
}
