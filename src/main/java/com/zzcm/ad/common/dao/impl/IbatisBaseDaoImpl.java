package com.zzcm.ad.common.dao.impl;

import java.util.List;
import java.util.Map;

import com.zzcm.ad.common.dao.IbatisBaseDao;
import com.zzcm.ad.common.dao.IbatisDaoReader;
import com.zzcm.ad.common.dao.IbatisDaoWriter;
import com.zzcm.ad.common.exception.JdbcException;

/**
 * 对数据库操作的基础类，实现了读写分离
 * @author shunyang
 *
 */
public class IbatisBaseDaoImpl implements IbatisBaseDao {
	private IbatisDaoReader ibatisDaoReader;
	private IbatisDaoWriter ibatisDaoWriter;
	
	public IbatisDaoReader getIbatisDaoReader() {
		return ibatisDaoReader;
	}
	public void setIbatisDaoReader(IbatisDaoReader ibatisDaoReader) {
		this.ibatisDaoReader = ibatisDaoReader;
	}
	public IbatisDaoWriter getIbatisDaoWriter() {
		return ibatisDaoWriter;
	}
	public void setIbatisDaoWriter(IbatisDaoWriter ibatisDaoWriter) {
		this.ibatisDaoWriter = ibatisDaoWriter;
	}
	@Override
	public Integer save(String statementName, Object obj)throws JdbcException {
		return ibatisDaoWriter.save(statementName, obj);
	}
	@Override
	public Integer save(String statementName) throws JdbcException {
		return ibatisDaoWriter.save(statementName);
	}
	@Override
	public int update(String statementName, Object obj) throws JdbcException {
		return ibatisDaoWriter.update(statementName, obj);
	}
	@Override
	public int update(String statementName) throws JdbcException {
		return ibatisDaoWriter.update(statementName);
	}
	@Override
	public int delete(String statementName, Object obj)throws JdbcException {
		return ibatisDaoWriter.delete(statementName,obj);
	}
	@Override
	public int delete(String statementName) throws JdbcException {
		return ibatisDaoWriter.delete(statementName);
	}
	@Override
	public <T> T queryForObject(String statementName) {
		return ibatisDaoReader.queryForObject(statementName);
	}
	@Override
	public <T> T queryForObject(String statementName, Object obj) {
		return ibatisDaoReader.queryForObject(statementName, obj);
	}
	@Override
	public <T> List<T> queryForList(String statementName) {
		return ibatisDaoReader.queryForList(statementName);
	}
	@Override
	public <T> List<T> queryForList(String statementName, Object obj) {
		return ibatisDaoReader.queryForList(statementName, obj);
	}
	@Override
	public <T> Map queryForMap(String statementName, Object obj,
			String keyProperty) {
		return ibatisDaoReader.queryForMap(statementName, obj, keyProperty);
	}
	@Override
	public <T> Map queryForMap(String statementName, Object obj,
			String keyProperty, String valueProperty) {
		return ibatisDaoReader.queryForMap(statementName, obj, keyProperty, valueProperty);
	}

}
