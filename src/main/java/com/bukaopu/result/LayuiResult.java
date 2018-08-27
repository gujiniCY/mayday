package com.bukaopu.result;

import java.util.HashMap;
import java.util.List;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年8月27日 下午2:01:17
*/
public class LayuiResult extends HashMap<String, Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**layui数据表格返回格式
	 * @param  
	 * @param map */
	public static LayuiResult data(Integer count,List<?> data){
		LayuiResult r=new LayuiResult();
		r.put("code", 0);
		r.put("msg", "");
		r.put("count",count);
		r.put("data",data);
		return r;
	}
}
