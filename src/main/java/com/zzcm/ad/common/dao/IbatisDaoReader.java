package com.zzcm.ad.common.dao;

import java.util.List;
import java.util.Map;

public interface IbatisDaoReader{
	/**
	 * 根据statementName查询，返回对象
	 * @param statementName
	 * @return
	 */
	public abstract <T> T  queryForObject(String  statementName);
	/**
	 * 根据statementName，参数obj查询，返回对象
	 * @param statementName
	 * @param obj
	 * @return
	 */
	public abstract <T> T  queryForObject(String  statementName, Object obj);
	/**
	 * 根据statementName查询，返回对象集合List
	 * @param statementName
	 * @return
	 */
	public abstract <T> List<T>  queryForList(String  statementName);
	/**
	 * 根据statementName，参数obj查询,返回对象集合List
	 * @param statementName
	 * @param obj
	 * @return
	 */
	public abstract <T> List<T>  queryForList(String  statementName, Object obj);
	/**
	 * 根据statementName，参数obj,返回Map key值查询，返回Map
	 * @param statementName
	 * @param obj
	 * @param keyProperty
	 * @return
	 */
	public abstract <T> Map queryForMap(String statementName,Object obj, String keyProperty);
	/**
	 * 根据statementName、参数obj、返回Map key值、返回map value查询，返回Map
	 * @param statementName
	 * @param obj
	 * @param keyProperty
	 * @param valueProperty
	 * @return
	 */
	public abstract <T> Map queryForMap(String statementName,Object obj, String keyProperty,String valueProperty);
}
