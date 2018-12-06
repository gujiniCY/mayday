package com.songhaozhi.mayday.util;

import org.springframework.stereotype.Component;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年12月6日 上午10:22:49
*/
@Component
public class Commons {
	
	private static final String[] ICONS = {"bg-ico-book", "bg-ico-game", "bg-ico-note", "bg-ico-chat", "bg-ico-code", "bg-ico-image", "bg-ico-web", "bg-ico-link", "bg-ico-design", "bg-ico-lock"};

    /**
     * 显示文章图标
     *
     * @param id
     * @return
     */
    public static String show_icon(int id) {
        return ICONS[id % ICONS.length];
    }
    public static String show_categories(String categorys) {
    	
		return null;
    }

}
