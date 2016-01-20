package com.dongyuan.figting.core.fieldpack.interceptor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.dongyuan.figting.core.fieldpack.annotions.PackEntity;
import com.dongyuan.figting.utils.JedisUtil;
import org.apache.commons.lang.reflect.FieldUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName: PackResolverInterceptor
 * @Description: 属性包装器
 * @author 汪海霖 wanghl15@midea.com.cn
 * @date 2014-9-30 下午8:59:23
 */
@Aspect
@Component
public class PackResolverInterceptor {
	
	private static List<Class<?>> elemClassList;
	
	@PostConstruct
	public void initMethod(){
		elemClassList = new ArrayList<Class<?>>();
		elemClassList.add(String.class);
		elemClassList.add(Boolean.class);
		elemClassList.add(boolean.class);
		elemClassList.add(Byte.class);
		elemClassList.add(byte.class);
		elemClassList.add(Integer.class);
		elemClassList.add(int.class);
		elemClassList.add(Long.class);
		elemClassList.add(long.class);
		elemClassList.add(BigDecimal.class);
		elemClassList.add(Date.class);
		elemClassList.add(Short.class);
		elemClassList.add(short.class);
		elemClassList.add(Float.class);
		elemClassList.add(float.class);
		elemClassList.add(Double.class);
		elemClassList.add(double.class);
		elemClassList.add(Character.class);
		elemClassList.add(char.class);
	}

	@Autowired
	private JdbcTemplate coreJdbcTemplate;

	@Pointcut("execution(@com.dongyuan.figting.core.fieldpack.annotions.PackTarget * *(..))")
	private void pointRepeat() {
	}// 切入点的名称就是方法名

	@Around("pointRepeat()")
	// 定义切入点allMethod()的环绕通知,环绕通知方法一定要按照下面的形式定义(只可以修改方法名和参数名)
	public Object doSomethingAround(ProceedingJoinPoint point) throws Throwable {
//		System.out.println("doSomethingAround.");
		Object result = point.proceed();
		dealCommonObject(result);

		return result;
	}

	private void dealCommonObject(Object result) throws IllegalAccessException {
		if (result instanceof List<?>) {
			dealList((List<?>) result);
		} else {
			dealObject(result);
		}

	}

	private void dealList(List<?> list) throws IllegalAccessException {
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		for (int index = 0; index < list.size(); index++) {
			Object target = list.get(index);
			if(!elemClassList.contains(target.getClass())){
				dealObject(target);
			}
		}
	}

	private void dealObject(Object target) throws IllegalAccessException {
		if (target == null) {
			return;
		}
		Field[] fields = target.getClass().getDeclaredFields();
		if (fields != null) {
			for (Field field : fields) {
				PackEntity entity = field.getAnnotation(PackEntity.class);
				if (entity != null) {
					Field idField = FieldUtils.getField(target.getClass(),
							entity.idFieldName(), true);
					if (idField != null) {
						Object idValue = FieldUtils.readField(idField, target,
								true);
						if (idValue != null) {
							String value = readValFromCacheOrDb(idValue, entity);
							if (!StringUtils.isEmpty(value)) {
								FieldUtils.writeField(field, target, value,
										true);
							}
						}
					}
				}else{
					Class<?> clazz = field.getType();
					if(clazz == List.class || !elemClassList.contains(clazz)){
						dealCommonObject(FieldUtils.readField(field, target, true));
					}
				}
			}
		}
	}

//	@SuppressWarnings("rawtypes")
//	private void dealBodyData(BodyData bd) throws IllegalAccessException {
//		if (bd == null) {
//			return;
//		}
//		Object content = bd.getContent();
//		Object realObject = content;
//		if (content instanceof PageInfo) {
//			realObject = ((PageInfo) content).getList();
//		}
//
//		dealCommonObject(realObject);
//	}

	private String readValFromCacheOrDb(Object idValue, PackEntity entity) {
		String cacheKey = entity.cacheKey().concat(idValue.toString());
//		System.out.println(cacheKey);
		String value = JedisUtil.getJedisInstance().execGetFromCache(cacheKey);
		if (value == null) {
			// value = jdbcTemplate.queryForObject(querySql,
			// new Object[]{idValue},String.class);
			List<Map<String, Object>> list = coreJdbcTemplate.queryForList(
					entity.querySql(), idValue);
//			System.out.println("querySql:" + entity.querySql());
			if (!CollectionUtils.isEmpty(list)) {
				Object dbValue = list.get(0).get(entity.dbColumn());
				if (dbValue != null) {
					value = dbValue.toString();
				}
			}
			int expireTime = 3600;
			if(value == null){
				expireTime = 300;
			}
			JedisUtil.getJedisInstance().execSetexToCache(cacheKey, expireTime,
					value == null ? "" : value);
		} else if ("".equals(value)) {
			value = null;
		}
		return value;
	}

}
