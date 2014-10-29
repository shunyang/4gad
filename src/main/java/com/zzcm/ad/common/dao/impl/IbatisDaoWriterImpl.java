package com.zzcm.ad.common.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.Assert;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zzcm.ad.common.dao.IbatisDaoWriter;
import com.zzcm.ad.common.exception.JdbcException;
/**
 * 对数据库写操作的实现类
 * @author shunyang
 *
 */
public final class IbatisDaoWriterImpl extends SqlMapClientDaoSupport implements IbatisDaoWriter {

	private static final Logger logger = LoggerFactory.getLogger(IbatisDaoReaderImpl.class);

	@Resource(name = "sqlMapClientWriter")
	private SqlMapClient sqlMapClientWriter;
	@PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClientWriter);
	} 
	
	public Integer save(String  statementName,Object obj) {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return (Integer) this.getSqlMapClientTemplate().insert(statementName, obj);
		} catch (Exception e) {
			logger.error("Something's wrong when save Object:");
			logger.error(obj.getClass().getName());
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}

	@Override
	public Integer save(String statementName) throws JdbcException {
		Assert.notNull(statementName);
		try {
			return (Integer) this.getSqlMapClientTemplate().insert(statementName);
		} catch (Exception e) {
			logger.error("Something's wrong when save Object:");
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
	
	@Override
	public int update(String statementName, Object obj)
			throws JdbcException {
		Assert.notNull(statementName);
		Assert.notNull(obj);
		try {
			return (Integer) this.getSqlMapClientTemplate().update(statementName, obj);
		} catch (Exception e) {
			logger.error("Something's wrong when update Object:");
			logger.error(obj.getClass().getName());
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}

	@Override
	public int update(String statementName) throws JdbcException {
		Assert.notNull(statementName);
		try {
			return (Integer) this.getSqlMapClientTemplate().update(statementName);
		} catch (Exception e) {
			logger.error("Something's wrong when update Object:");
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}

	@Override
	public int delete(String statementName) throws JdbcException {
		Assert.notNull(statementName);
		try {
			return  this.getSqlMapClientTemplate().delete(statementName);
		} catch (Exception e) {
			logger.error("Something's wrong when delete Object:");
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}

	@Override
	public int delete(String statementName, Object obj)
			throws JdbcException {
		Assert.notNull(statementName);
		try {
			return  this.getSqlMapClientTemplate().delete(statementName,obj);
		} catch (Exception e) {
			logger.error("Something's wrong when delete Object:");
			logger.error(obj.getClass().getName());
			logger.error("statementName:"+statementName);
			throw new JdbcException(this.getClass() + "->" + e.getMessage(), e);
		}
	}
}
