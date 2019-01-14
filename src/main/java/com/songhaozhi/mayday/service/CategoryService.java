package com.songhaozhi.mayday.service;

import java.util.List;

import com.songhaozhi.mayday.model.domain.Category;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月26日
 * 
 */
public interface CategoryService {
	/**
	 * 查询所有分类
	 * 
	 * @return
	 */
	List<Category> findCategory();

	/**
	 * 根据id查询
	 * 
	 * @param categoryId
	 * @return
	 */
	Category findByCategoryId(int categoryId);

	/**
	 * 添加
	 * 
	 * @param category
	 */
	void save(Category category) throws Exception;

	/**
	 * 修改
	 * 
	 * @param category
	 */
	void update(Category category) throws Exception;

	/**
	 * 删除
	 * 
	 * @param categoryId
	 */
	void delete(int categoryId) throws Exception;

	/**
	 * 验证是否存在该路径
	 * 
	 * @param cateUrl
	 * @return
	 */
	Category findByCateUrl(String cateUrl);

}
