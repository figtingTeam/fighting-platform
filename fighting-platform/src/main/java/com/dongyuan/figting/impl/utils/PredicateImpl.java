package com.dongyuan.figting.impl.utils;

import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

public class PredicateImpl implements Predicate {
	private String property;
	private Object value;

	public PredicateImpl(String property, Object value) {
		this.property = property;
		this.value = value;
	}

	public boolean evaluate(Object object) {
		try {
			Object beanValue;
			if (property.indexOf(".") > 0) {
				beanValue = PropertyUtils.getNestedProperty(object, property);
			} else {
				beanValue = PropertyUtils.getProperty(object, property);
			}
			if (beanValue == null) {
				return false;
			}
			if (!value.getClass().equals(beanValue.getClass())) {
				throw new RuntimeException("value.class!=beanValue.class");
			}
			return myCompare(beanValue, value);

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

	private boolean myCompare(Object value, Object beanValue) {
		if (beanValue.getClass().equals(Integer.class)) {
			if (beanValue.equals(value)) {
				return true;
			}
		}
		if (beanValue.getClass().equals(BigDecimal.class)) {
			if (((BigDecimal) beanValue).compareTo((BigDecimal) value) == 0) {
				return true;
			}
		}
		if (beanValue.getClass().equals(String.class)) {
			if (beanValue.toString().equals(value.toString())) {
				return true;
			}
		} else {
			if (beanValue.equals(value)) {
				return true;
			}
		}
		return false;
	}

}
