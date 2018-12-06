package com.songhaozhi.mayday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songhaozhi.mayday.mapper.generator.CategoryMapper;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.service.CategoryService;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年9月26日 下午8:40:51
 * 
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findCategory() throws Exception {
		return categoryMapper.selectByExample(null);
	}

	@Override
	public Category findByCategoryId(int categoryId) throws Exception {
		return categoryMapper.selectByPrimaryKey(categoryId);
	}

	@Override
	public void save(Category category) throws Exception {
		categoryMapper.insert(category);
	}

	@Override
	public void update(Category category) throws Exception {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public void delete(int categoryId) throws Exception {
		categoryMapper.deleteByPrimaryKey(categoryId);
	}

}
