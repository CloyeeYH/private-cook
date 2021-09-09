/**
 * 
 */
package com.hpe.service;

import java.util.List;

import com.hpe.pojo.Types;

/** 
 * 类描述：
 * 作者：yuhui
 * 创建日期：2019年9月3日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0   
 */

public interface ITypesService {

	/**
	 * 
	 * 方法描述：查询所有类别
	 * @return 所有类别信息
	 */
	List<Types> getTypesAll();
	
	/**
	 * 
	 * 方法描述：添加类别
	 * @param types 类别信息
	 * @return  影响的行数
	 */
	int addTypes(Types types);
	/**
	 * 
	 * 方法描述：修改类别
	 * @param name 要被修改的类型名称
	 * @param types 修改后的类型
	 * @return 影响的行数
	 */
	int updateTypes(Types types);
	/**
	 * 
	 * 方法描述：根据id查询
	 * @param id id
	 * @return 类别信息
	 */
	Types getTypesById(int id);
	/**
	 * 
	 * 方法描述：根据id删除类别信息
	 * @param id
	 * @return 影响的 行数
	 */
	int deleteTypes(int id);
}
