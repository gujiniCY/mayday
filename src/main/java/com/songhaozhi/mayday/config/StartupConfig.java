package com.songhaozhi.mayday.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.songhaozhi.mayday.model.domain.Options;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.service.OptionsService;

/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年10月30日 上午11:05:45
*/
@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private OptionsService optionsService;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		this.loadOptions();
	}
	/**
     * 加载设置选项
     */
    private void loadOptions() {
    	List<Options> ListMap = optionsService.selectMap();
		if(ListMap.size()>0 && !ListMap.isEmpty()) {
			for (Options options : ListMap) {
				MaydayConst.options.put(options.getOptionName(), options.getOptionValue());
			}
		}
    }

}
