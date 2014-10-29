package com.zzcm.ad.common.exception;

import org.springframework.core.NestedRuntimeException;

public class JdbcException extends NestedRuntimeException{
	
	private static final long serialVersionUID = 1071304813707902199L;

	public JdbcException(String msg){
		super(msg);
	}
	
	public JdbcException(String msg,Exception e){
		super(msg, e);
	}
	
	public JdbcException(Exception e){
		this("",e);
	}
	
}
