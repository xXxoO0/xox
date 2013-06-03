package com.xox.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xox.model.entity.User;

public interface UserDao {
	/**
	 * 插入数据
	 * @param user
	 */
	public void insert(User user);
	
	/**
	 * 更新数据
	 * @param user
	 * @return
	 */
	public void update(User user);
	
	/**
	 * 通过id进行查询
	 * @param id
	 * @return
	 */
	public User get(long id);
	
	/**
	 * 通过Id删除数据
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 *通过where条件查询相应数据集
	 *@param sqlWhere
	 */
	public List<User> findByWhere(@Param(value="sqlWhere")String sqlWhere); 
	
	/**
	 *通过where条件删除相应数据集
	 *@param sqlWhere
	 */
	public List<User> deleteByWhere(@Param(value="sqlWhere")String sqlWhere); 
	
	/**
	 *根据两个Id进行上移、下移操作
	 *@param sqlWhere
	 */
	public void upAndDown(@Param(value="idA")long idA,@Param(value="idB")long idB);
	
	
}
