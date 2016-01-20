package com.dongyuan.figting.impl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderAddrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderAddrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIsNull() {
            addCriterion("receiver_province is null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIsNotNull() {
            addCriterion("receiver_province is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceEqualTo(Integer value) {
            addCriterion("receiver_province =", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotEqualTo(Integer value) {
            addCriterion("receiver_province <>", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThan(Integer value) {
            addCriterion("receiver_province >", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_province >=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThan(Integer value) {
            addCriterion("receiver_province <", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_province <=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIn(List<Integer> values) {
            addCriterion("receiver_province in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotIn(List<Integer> values) {
            addCriterion("receiver_province not in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceBetween(Integer value1, Integer value2) {
            addCriterion("receiver_province between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_province not between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameIsNull() {
            addCriterion("receiver_province_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameIsNotNull() {
            addCriterion("receiver_province_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameEqualTo(String value) {
            addCriterion("receiver_province_name =", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameNotEqualTo(String value) {
            addCriterion("receiver_province_name <>", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameGreaterThan(String value) {
            addCriterion("receiver_province_name >", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_province_name >=", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameLessThan(String value) {
            addCriterion("receiver_province_name <", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_province_name <=", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameLike(String value) {
            addCriterion("receiver_province_name like", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameNotLike(String value) {
            addCriterion("receiver_province_name not like", value, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameIn(List<String> values) {
            addCriterion("receiver_province_name in", values, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameNotIn(List<String> values) {
            addCriterion("receiver_province_name not in", values, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameBetween(String value1, String value2) {
            addCriterion("receiver_province_name between", value1, value2, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNameNotBetween(String value1, String value2) {
            addCriterion("receiver_province_name not between", value1, value2, "receiverProvinceName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNull() {
            addCriterion("receiver_city is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNotNull() {
            addCriterion("receiver_city is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityEqualTo(Integer value) {
            addCriterion("receiver_city =", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotEqualTo(Integer value) {
            addCriterion("receiver_city <>", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThan(Integer value) {
            addCriterion("receiver_city >", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_city >=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThan(Integer value) {
            addCriterion("receiver_city <", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_city <=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIn(List<Integer> values) {
            addCriterion("receiver_city in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotIn(List<Integer> values) {
            addCriterion("receiver_city not in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityBetween(Integer value1, Integer value2) {
            addCriterion("receiver_city between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_city not between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameIsNull() {
            addCriterion("receiver_city_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameIsNotNull() {
            addCriterion("receiver_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameEqualTo(String value) {
            addCriterion("receiver_city_name =", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameNotEqualTo(String value) {
            addCriterion("receiver_city_name <>", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameGreaterThan(String value) {
            addCriterion("receiver_city_name >", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_city_name >=", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameLessThan(String value) {
            addCriterion("receiver_city_name <", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_city_name <=", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameLike(String value) {
            addCriterion("receiver_city_name like", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameNotLike(String value) {
            addCriterion("receiver_city_name not like", value, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameIn(List<String> values) {
            addCriterion("receiver_city_name in", values, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameNotIn(List<String> values) {
            addCriterion("receiver_city_name not in", values, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameBetween(String value1, String value2) {
            addCriterion("receiver_city_name between", value1, value2, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNameNotBetween(String value1, String value2) {
            addCriterion("receiver_city_name not between", value1, value2, "receiverCityName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIsNull() {
            addCriterion("receiver_county is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIsNotNull() {
            addCriterion("receiver_county is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyEqualTo(Integer value) {
            addCriterion("receiver_county =", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotEqualTo(Integer value) {
            addCriterion("receiver_county <>", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyGreaterThan(Integer value) {
            addCriterion("receiver_county >", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_county >=", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLessThan(Integer value) {
            addCriterion("receiver_county <", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_county <=", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIn(List<Integer> values) {
            addCriterion("receiver_county in", values, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotIn(List<Integer> values) {
            addCriterion("receiver_county not in", values, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyBetween(Integer value1, Integer value2) {
            addCriterion("receiver_county between", value1, value2, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_county not between", value1, value2, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameIsNull() {
            addCriterion("receiver_county_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameIsNotNull() {
            addCriterion("receiver_county_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameEqualTo(String value) {
            addCriterion("receiver_county_name =", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameNotEqualTo(String value) {
            addCriterion("receiver_county_name <>", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameGreaterThan(String value) {
            addCriterion("receiver_county_name >", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_county_name >=", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameLessThan(String value) {
            addCriterion("receiver_county_name <", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_county_name <=", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameLike(String value) {
            addCriterion("receiver_county_name like", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameNotLike(String value) {
            addCriterion("receiver_county_name not like", value, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameIn(List<String> values) {
            addCriterion("receiver_county_name in", values, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameNotIn(List<String> values) {
            addCriterion("receiver_county_name not in", values, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameBetween(String value1, String value2) {
            addCriterion("receiver_county_name between", value1, value2, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNameNotBetween(String value1, String value2) {
            addCriterion("receiver_county_name not between", value1, value2, "receiverCountyName");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailIsNull() {
            addCriterion("receiver_addr_detail is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailIsNotNull() {
            addCriterion("receiver_addr_detail is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailEqualTo(String value) {
            addCriterion("receiver_addr_detail =", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailNotEqualTo(String value) {
            addCriterion("receiver_addr_detail <>", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailGreaterThan(String value) {
            addCriterion("receiver_addr_detail >", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_addr_detail >=", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailLessThan(String value) {
            addCriterion("receiver_addr_detail <", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailLessThanOrEqualTo(String value) {
            addCriterion("receiver_addr_detail <=", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailLike(String value) {
            addCriterion("receiver_addr_detail like", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailNotLike(String value) {
            addCriterion("receiver_addr_detail not like", value, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailIn(List<String> values) {
            addCriterion("receiver_addr_detail in", values, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailNotIn(List<String> values) {
            addCriterion("receiver_addr_detail not in", values, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailBetween(String value1, String value2) {
            addCriterion("receiver_addr_detail between", value1, value2, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverAddrDetailNotBetween(String value1, String value2) {
            addCriterion("receiver_addr_detail not between", value1, value2, "receiverAddrDetail");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIsNull() {
            addCriterion("receiver_zip is null");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIsNotNull() {
            addCriterion("receiver_zip is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverZipEqualTo(Integer value) {
            addCriterion("receiver_zip =", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotEqualTo(Integer value) {
            addCriterion("receiver_zip <>", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipGreaterThan(Integer value) {
            addCriterion("receiver_zip >", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_zip >=", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipLessThan(Integer value) {
            addCriterion("receiver_zip <", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_zip <=", value, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipIn(List<Integer> values) {
            addCriterion("receiver_zip in", values, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotIn(List<Integer> values) {
            addCriterion("receiver_zip not in", values, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipBetween(Integer value1, Integer value2) {
            addCriterion("receiver_zip between", value1, value2, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverZipNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_zip not between", value1, value2, "receiverZip");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNull() {
            addCriterion("receiver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIsNotNull() {
            addCriterion("receiver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            addCriterion("receiver_phone =", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            addCriterion("receiver_phone <>", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            addCriterion("receiver_phone >", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_phone >=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            addCriterion("receiver_phone <", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            addCriterion("receiver_phone <=", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneLike(String value) {
            addCriterion("receiver_phone like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            addCriterion("receiver_phone not like", value, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            addCriterion("receiver_phone in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            addCriterion("receiver_phone not in", values, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            addCriterion("receiver_phone between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            addCriterion("receiver_phone not between", value1, value2, "receiverPhone");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}