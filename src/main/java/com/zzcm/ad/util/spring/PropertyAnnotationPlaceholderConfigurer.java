package com.zzcm.ad.util.spring;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 自定义spring属性文件加载
 * 添加注解注入
 * <br/>
 * example:
 * <pre>
 * <code>
 * @Property(告诉他，这个类会用到属性注解注解数据)
 * public class MyClass
 * {
 *	private String name;
 *	@Property("${properties.key}")
 *	public void setName(String name){
 *		this.name=name;
 *	}
 * }
 * </code>
 * </pre>
 * @author tangl
 * @date   2011-11-17
 */
public class PropertyAnnotationPlaceholderConfigurer extends PropertyPlaceholderConfigurer implements BeanPostProcessor, InitializingBean
{
	private Logger logger=Logger.getLogger(PropertyAnnotationPlaceholderConfigurer.class);
	
	private java.util.Properties pros;
	
	public Object postProcessAfterInitialization(Object bean, String beanName)throws BeansException{
		logger.debug(bean.getClass()+" postProcessAfterInitialization init....["+beanName+"]");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)throws BeansException {
		if (bean.getClass().getAnnotation(Property.class) != null) {
			Method[] methods = bean.getClass().getDeclaredMethods();
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				Property p = field.getAnnotation(Property.class);
				if (p != null) {
					//这里进行参数类型转换
					Object para = pros.getProperty(p.name());
					try{
						field.setAccessible(true);
						Class<?> pt=field.getType();
						if(pt==null || para==null){
							logger.warn("参数为空!!!");
							continue;
						}
						if(pt==Boolean.class || pt==boolean.class){
							field.setBoolean(bean,Boolean.valueOf(para.toString()));
						}else if(pt==int.class || pt==Integer.class){
							field.setInt(bean,Integer.parseInt(para.toString()));
						}else{
							field.set(bean, para);
						}
					}catch(Exception e){
						logger.error("设置["+bean.getClass()+"] 下的 属性["+field+"]异常!!!",e);
					}
				}
			}
			for (Method method : methods) {
				Property p = method.getAnnotation(Property.class);
				if (p != null) {
					//这里进行参数类型转换
					Object para = pros.getProperty(p.name());
					try{
						method.setAccessible(true);
						Class<?>[] pt=method.getParameterTypes();
						if(pt==null || pt.length>1 || para==null){
							logger.warn("方法设置异常,参数不等于1个method["+method.getName()+"]");
							continue;
						}
						if(pt[0]==Boolean.class || pt[0]==boolean.class){
							method.invoke(bean,Boolean.valueOf(para.toString()));
						}else if(pt[0]==Integer.class || pt[0]==int.class){
							method.invoke(bean,Integer.valueOf(para.toString()));
						}else{
							method.invoke(bean,para);
						}
					}catch(Exception e){
						logger.error("设置["+bean.getClass()+"] 下的 方法["+method+"]异常!!!",e);
					}
				}
			}
		}

		logger.debug(bean.getClass()+ " postProcessBeforeInitialization init....["+ beanName + "]");
		return bean;
	}
	
	public void afterPropertiesSet() throws Exception {
		pros = mergeProperties();
		logger.debug("afterPropertiesSet ....["+pros+"]");
	}
	
	/**
	 * 返回所有配置文件
	 * @return
	 */
	public Properties getConfigProperties()
	{
		if(this.pros==null)
		{
			return new Properties();
		}
		return this.pros;
	}
}
