package com.zzcm.ad.common.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.Assert;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zzcm.ad.common.dao.IbatisDaoReader;
import com.zzcm.ad.common.exception.JdbcException;

/**
 * 对数据库读操作的实现类
 * @author shunyang
 *
 */
public final class IbatisDaoReaderImpl extends SqlMapClientDaoSupport implements IbatisDaoReader {
	private static final Logger logger = LoggerFactory.getLogger(IbatisDaoReaderImpl.class);
	@Resource(name="sqlMapClientReader")
	private SqlMapClient sqlMapClientReader;
	@PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClientReader);
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T queryForObject(String statementName) throws JdbcException{
		Assert.notNull(statementName);
		try {
			return (T) this.getSqlMapClientTemplate().queryForObject(statementName);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	@Override
	public <T> T queryForObject(String statementName, Object obj) {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return (T) this.getSqlMapClientTemplate().queryForObject(statementName,obj);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("param:"+obj.getClass().getName());
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	@Override
	public <T> List<T> queryForList(String statementName) {
		Assert.notNull(statementName);
		try {
			return (List<T>) this.getSqlMapClientTemplate().queryForList(statementName);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	@Override
	public <T> List<T> queryForList(String statementName, Object obj) {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return (List<T>) this.getSqlMapClientTemplate().queryForList(statementName,obj);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("statementName:"+statementName);
			logger.error("param:"+obj.getClass().getName());
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	@Override
	public <T> Map queryForMap(String statementName, Object obj,String keyProperty) {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return this.getSqlMapClientTemplate().queryForMap(statementName, obj, keyProperty);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("statementName:"+statementName);
			logger.error("param:"+obj.getClass().getName()+"--->keyProperty:"+keyProperty);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	@Override
	public <T> Map queryForMap(String statementName, Object obj,String keyProperty, String valueProperty) {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return this.getSqlMapClientTemplate().queryForMap(statementName, obj, keyProperty, valueProperty);
		} catch (Exception e) {
			logger.error("Something's wrong when query :");
			logger.error("statementName:"+statementName);
			logger.error("param:"+obj.getClass().getName()+"--->keyProperty:"+keyProperty+"-->valueProperty:"+valueProperty);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
}
