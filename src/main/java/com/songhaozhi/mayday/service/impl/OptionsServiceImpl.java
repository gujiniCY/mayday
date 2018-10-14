package com.songhaozhi.mayday.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songhaozhi.mayday.mapper.custom.OptionsMapperCustom;
import com.songhaozhi.mayday.service.OptionsService;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年10月12日 上午10:07:36
 */
@Service
public class OptionsServiceImpl implements OptionsService {
	@Autowired
	private OptionsMapperCustom optionsMapperCustom;

	@Override
	public void save(Map<String, Object> map) {
		optionsMapperCustom.saveMap(map);
	}

	@Override
	public Map<String, Object> findAll() {
		return optionsMapperCustom.selectMap();
	}

	class MapResultHandler implements ResultHandler {
		private final Map mappedResults = new HashMap();

		@SuppressWarnings("unchecked")
		@Override
		public void handleResult(ResultContext context) {
			Map map = (Map) context.getResultObject();
			mappedResults.put(map.get("key"), map.get("value")); // xml 配置里面的property的值，对应的列
		}

		public Map getMappedResults() {
			return mappedResults;
		}

	}

}
