package com.zzcm.ad.util.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记类需要用到属性文件内容注入值<br/>
 * 标记方法/字段 使用注解注入
 * @author tangl
 * @date   2011-11-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD,ElementType.FIELD})
public @interface Property{
	/**
	 * 属性文件里的key名
	 * @return 字符串名字
	 */
	String name() default "";
}
