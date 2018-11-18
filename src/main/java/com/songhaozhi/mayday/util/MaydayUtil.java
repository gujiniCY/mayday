package com.songhaozhi.mayday.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年10月30日 下午3:26:42
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
		String result = "";
		try {
			URL url = new URL("	http://data.zz.baidu.com/urls?site=" + blogUrl + "&token=" + token + "");
			// 打开和url之间的连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			PrintWriter out = null;
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
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = br.readLine()) != null) {
				result += line;
			}
			// 关闭流
			is.close();
			// 断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
			// 固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
