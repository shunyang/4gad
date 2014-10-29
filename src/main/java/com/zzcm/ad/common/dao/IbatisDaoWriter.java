package com.zzcm.ad.common.dao;

import com.zzcm.ad.common.exception.JdbcException;

public interface IbatisDaoWriter{
	/**
	 * 保存一个实体对象
	 * @param statementName
	 * @param entity
	 * @return
	 * @throws JdbcException
	 */
	public abstract Integer save(String  statementName,Object obj) throws JdbcException;
	/**
	 * 保存
	 * @param statementName
	 * @return
	 * @throws JdbcException
	 */
	public abstract Integer save(String  statementName) throws JdbcException;
	/**
	 * 更新一个实体对象
	 * @param statementName
	 * @param entity
	 * @return
	 * @throws JdbcException
	 */
	public abstract int update(String  statementName,Object obj) throws JdbcException;
	/**
	 * 更新
	 * @param statementName
	 * @param entity
	 * @return
	 * @throws JdbcException
	 */
	public abstract int update(String  statementName) throws JdbcException;
	/**
	 * 按照条件删除记录
	 * @param statementName
	 * @param paramObj
	 * @return
	 * @throws JdbcException
	 */
	public abstract int delete(String  statementName,Object obj) throws JdbcException;
	/**
	 * 按照条件删除记录
	 * @param statementName
	 * @return
	 * @throws JdbcException
	 */
	public abstract int delete(String  statementName) throws JdbcException;
	
}
