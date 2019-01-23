package com.songhaozhi.mayday.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.util.Assert;

import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Description;
import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.WireFeedOutput;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月30日
 */
public class MaydayUtil {
	/**
	 * 推送百度
	 * 
	 * @param blog_url
	 *            在搜索资源平台验证的站点
	 * @param token
	 *            在搜索资源平台申请的推送用的准入密钥
	 * @param urls
	 *            文章路径
	 * @return
	 */
	public static String baiduPost(String blogUrl, String token, String urls) {
		StringBuffer result = new StringBuffer();
		PrintWriter out = null;
		BufferedReader br = null;
		try {
			URL url = new URL("	http://data.zz.baidu.com/urls?site=" + blogUrl + "&token=" + token + "");
			// 打开和url之间的连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("User-Agent", "curl/7.12.1");
			conn.setRequestProperty("Host", "data.zz.baidu.com*");
			conn.setRequestProperty("Content-Type", "text/plain");
			conn.setRequestProperty("Content-Length", "83");
			// 设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
			// 最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
			// post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数即数据
			out.print(urls.trim());
			// 缓冲数据
			out.flush();
			// 获取URLConnection对象对应的输入流
			InputStream is = conn.getInputStream();
			// 构造一个字符流缓存
			br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			// 关闭流
			is.close();
			// 断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
			// 固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (null != br) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	/**
	 * 转换文件大小
	 * 
	 * @param size
	 * @return
	 */
	public static String parseSize(long size) {
		if (size < 1024) {
			return String.valueOf(size) + "B";
		} else {
			size = size / 1024;
		}
		if (size < 1024) {
			return String.valueOf(size) + "KB";
		} else {
			size = size / 1024;
		}
		if (size < 1024) {
			size = size * 100;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
		} else {
			size = size * 100 / 1024;
			return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
		}
	}

	/**
	 * 获取文件长和宽
	 *
	 * @param file
	 *            file
	 * @return String
	 */
	public static String getImageWh(File file) {
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(file));
			return image.getWidth() + "x" + image.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	 * 生成rss
	 * @param articles
	 * @return
	 */
	public static String buildRss(List<ArticleCustom> articles)throws FeedException{
		 Assert.notEmpty(articles, "posts must not be empty");
		 Channel channel=new Channel();
		 channel.setFeedType("rss_2.0");
		 if(MaydayConst.OPTIONS.get("blog_name")==null) {
			 channel.setTitle("");
		 }else {
			 channel.setTitle(MaydayConst.OPTIONS.get("blog_name"));
		 }
		 if(MaydayConst.OPTIONS.get("blog_url")==null) {
			 channel.setLink("");
		 }else {
			 channel.setLink(MaydayConst.OPTIONS.get("blog_url"));
		 }
		 if(MaydayConst.OPTIONS.get("blog_url")==null) {
			 channel.setUri("");
		 }else {
			 channel.setUri(MaydayConst.OPTIONS.get("blog_url"));
		 }
		 if(MaydayConst.OPTIONS.get("seo_describe")==null) {
			 channel.setDescription("");
		 }else {
			 channel.setDescription(MaydayConst.OPTIONS.get("seo_describe"));
		 }
		channel.setLanguage("zh-CN");
		List<Item> items=new ArrayList<>();
		for (int i = 0; i < articles.size(); i++) {
			Item item=new Item();
			Description descr = new Description();
			item.setTitle(articles.get(i).getArticleTitle());
			item.setLink(MaydayConst.OPTIONS.get("blog_url")+"/post/"+articles.get(i).getArticleUrl());
			item.setPubDate(articles.get(i).getArticleNewstime());
			descr.setValue(articles.get(i).getArticleContent());
			item.setDescription(descr);
			items.add(item);
		}
		channel.setItems(items);
        WireFeedOutput out = new WireFeedOutput();
        return out.outputString(channel);
	}
	
}
