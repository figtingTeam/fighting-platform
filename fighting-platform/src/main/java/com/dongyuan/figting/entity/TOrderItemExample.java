package com.dongyuan.figting.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrderItemExample() {
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

        public Criteria andOrderItemIdIsNull() {
            addCriterion("order_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNotNull() {
            addCriterion("order_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdEqualTo(String value) {
            addCriterion("order_item_id =", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotEqualTo(String value) {
            addCriterion("order_item_id <>", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThan(String value) {
            addCriterion("order_item_id >", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_item_id >=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThan(String value) {
            addCriterion("order_item_id <", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThanOrEqualTo(String value) {
            addCriterion("order_item_id <=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLike(String value) {
            addCriterion("order_item_id like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotLike(String value) {
            addCriterion("order_item_id not like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIn(List<String> values) {
            addCriterion("order_item_id in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotIn(List<String> values) {
            addCriterion("order_item_id not in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdBetween(String value1, String value2) {
            addCriterion("order_item_id between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotBetween(String value1, String value2) {
            addCriterion("order_item_id not between", value1, value2, "orderItemId");
            return (Criteria) this;
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andShortCodeIsNull() {
            addCriterion("short_code is null");
            return (Criteria) this;
        }

        public Criteria andShortCodeIsNotNull() {
            addCriterion("short_code is not null");
            return (Criteria) this;
        }

        public Criteria andShortCodeEqualTo(String value) {
            addCriterion("short_code =", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeNotEqualTo(String value) {
            addCriterion("short_code <>", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeGreaterThan(String value) {
            addCriterion("short_code >", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeGreaterThanOrEqualTo(String value) {
            addCriterion("short_code >=", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeLessThan(String value) {
            addCriterion("short_code <", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeLessThanOrEqualTo(String value) {
            addCriterion("short_code <=", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeLike(String value) {
            addCriterion("short_code like", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeNotLike(String value) {
            addCriterion("short_code not like", value, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeIn(List<String> values) {
            addCriterion("short_code in", values, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeNotIn(List<String> values) {
            addCriterion("short_code not in", values, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeBetween(String value1, String value2) {
            addCriterion("short_code between", value1, value2, "shortCode");
            return (Criteria) this;
        }

        public Criteria andShortCodeNotBetween(String value1, String value2) {
            addCriterion("short_code not between", value1, value2, "shortCode");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemCntIsNull() {
            addCriterion("item_cnt is null");
            return (Criteria) this;
        }

        public Criteria andItemCntIsNotNull() {
            addCriterion("item_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andItemCntEqualTo(Short value) {
            addCriterion("item_cnt =", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntNotEqualTo(Short value) {
            addCriterion("item_cnt <>", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntGreaterThan(Short value) {
            addCriterion("item_cnt >", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntGreaterThanOrEqualTo(Short value) {
            addCriterion("item_cnt >=", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntLessThan(Short value) {
            addCriterion("item_cnt <", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntLessThanOrEqualTo(Short value) {
            addCriterion("item_cnt <=", value, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntIn(List<Short> values) {
            addCriterion("item_cnt in", values, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntNotIn(List<Short> values) {
            addCriterion("item_cnt not in", values, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntBetween(Short value1, Short value2) {
            addCriterion("item_cnt between", value1, value2, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemCntNotBetween(Short value1, Short value2) {
            addCriterion("item_cnt not between", value1, value2, "itemCnt");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(BigDecimal value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(BigDecimal value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(BigDecimal value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(BigDecimal value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<BigDecimal> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<BigDecimal> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemAmountIsNull() {
            addCriterion("item_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemAmountIsNotNull() {
            addCriterion("item_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemAmountEqualTo(BigDecimal value) {
            addCriterion("item_amount =", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_amount <>", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThan(BigDecimal value) {
            addCriterion("item_amount >", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount >=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThan(BigDecimal value) {
            addCriterion("item_amount <", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount <=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountIn(List<BigDecimal> values) {
            addCriterion("item_amount in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_amount not in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount not between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Byte value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Byte value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Byte value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Byte value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Byte value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Byte> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Byte> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Byte value1, Byte value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNull() {
            addCriterion("refund_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIsNotNull() {
            addCriterion("refund_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundStatusEqualTo(Byte value) {
            addCriterion("refund_status =", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotEqualTo(Byte value) {
            addCriterion("refund_status <>", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThan(Byte value) {
            addCriterion("refund_status >", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("refund_status >=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThan(Byte value) {
            addCriterion("refund_status <", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusLessThanOrEqualTo(Byte value) {
            addCriterion("refund_status <=", value, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusIn(List<Byte> values) {
            addCriterion("refund_status in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotIn(List<Byte> values) {
            addCriterion("refund_status not in", values, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusBetween(Byte value1, Byte value2) {
            addCriterion("refund_status between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andRefundStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("refund_status not between", value1, value2, "refundStatus");
            return (Criteria) this;
        }

        public Criteria andSalemanIdIsNull() {
            addCriterion("saleman_id is null");
            return (Criteria) this;
        }

        public Criteria andSalemanIdIsNotNull() {
            addCriterion("saleman_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalemanIdEqualTo(Long value) {
            addCriterion("saleman_id =", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdNotEqualTo(Long value) {
            addCriterion("saleman_id <>", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdGreaterThan(Long value) {
            addCriterion("saleman_id >", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("saleman_id >=", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdLessThan(Long value) {
            addCriterion("saleman_id <", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdLessThanOrEqualTo(Long value) {
            addCriterion("saleman_id <=", value, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdIn(List<Long> values) {
            addCriterion("saleman_id in", values, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdNotIn(List<Long> values) {
            addCriterion("saleman_id not in", values, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdBetween(Long value1, Long value2) {
            addCriterion("saleman_id between", value1, value2, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanIdNotBetween(Long value1, Long value2) {
            addCriterion("saleman_id not between", value1, value2, "salemanId");
            return (Criteria) this;
        }

        public Criteria andSalemanNameIsNull() {
            addCriterion("saleman_name is null");
            return (Criteria) this;
        }

        public Criteria andSalemanNameIsNotNull() {
            addCriterion("saleman_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalemanNameEqualTo(String value) {
            addCriterion("saleman_name =", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameNotEqualTo(String value) {
            addCriterion("saleman_name <>", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameGreaterThan(String value) {
            addCriterion("saleman_name >", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameGreaterThanOrEqualTo(String value) {
            addCriterion("saleman_name >=", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameLessThan(String value) {
            addCriterion("saleman_name <", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameLessThanOrEqualTo(String value) {
            addCriterion("saleman_name <=", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameLike(String value) {
            addCriterion("saleman_name like", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameNotLike(String value) {
            addCriterion("saleman_name not like", value, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameIn(List<String> values) {
            addCriterion("saleman_name in", values, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameNotIn(List<String> values) {
            addCriterion("saleman_name not in", values, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameBetween(String value1, String value2) {
            addCriterion("saleman_name between", value1, value2, "salemanName");
            return (Criteria) this;
        }

        public Criteria andSalemanNameNotBetween(String value1, String value2) {
            addCriterion("saleman_name not between", value1, value2, "salemanName");
            return (Criteria) this;
        }

        public Criteria andTradeFromIsNull() {
            addCriterion("trade_from is null");
            return (Criteria) this;
        }

        public Criteria andTradeFromIsNotNull() {
            addCriterion("trade_from is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFromEqualTo(String value) {
            addCriterion("trade_from =", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotEqualTo(String value) {
            addCriterion("trade_from <>", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromGreaterThan(String value) {
            addCriterion("trade_from >", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromGreaterThanOrEqualTo(String value) {
            addCriterion("trade_from >=", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLessThan(String value) {
            addCriterion("trade_from <", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLessThanOrEqualTo(String value) {
            addCriterion("trade_from <=", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromLike(String value) {
            addCriterion("trade_from like", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotLike(String value) {
            addCriterion("trade_from not like", value, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromIn(List<String> values) {
            addCriterion("trade_from in", values, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotIn(List<String> values) {
            addCriterion("trade_from not in", values, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromBetween(String value1, String value2) {
            addCriterion("trade_from between", value1, value2, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andTradeFromNotBetween(String value1, String value2) {
            addCriterion("trade_from not between", value1, value2, "tradeFrom");
            return (Criteria) this;
        }

        public Criteria andPackingWayIsNull() {
            addCriterion("packing_way is null");
            return (Criteria) this;
        }

        public Criteria andPackingWayIsNotNull() {
            addCriterion("packing_way is not null");
            return (Criteria) this;
        }

        public Criteria andPackingWayEqualTo(Byte value) {
            addCriterion("packing_way =", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayNotEqualTo(Byte value) {
            addCriterion("packing_way <>", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayGreaterThan(Byte value) {
            addCriterion("packing_way >", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("packing_way >=", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayLessThan(Byte value) {
            addCriterion("packing_way <", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayLessThanOrEqualTo(Byte value) {
            addCriterion("packing_way <=", value, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayIn(List<Byte> values) {
            addCriterion("packing_way in", values, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayNotIn(List<Byte> values) {
            addCriterion("packing_way not in", values, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayBetween(Byte value1, Byte value2) {
            addCriterion("packing_way between", value1, value2, "packingWay");
            return (Criteria) this;
        }

        public Criteria andPackingWayNotBetween(Byte value1, Byte value2) {
            addCriterion("packing_way not between", value1, value2, "packingWay");
            return (Criteria) this;
        }

        public Criteria andProductAttributeIsNull() {
            addCriterion("product_attribute is null");
            return (Criteria) this;
        }

        public Criteria andProductAttributeIsNotNull() {
            addCriterion("product_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andProductAttributeEqualTo(Byte value) {
            addCriterion("product_attribute =", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeNotEqualTo(Byte value) {
            addCriterion("product_attribute <>", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeGreaterThan(Byte value) {
            addCriterion("product_attribute >", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_attribute >=", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeLessThan(Byte value) {
            addCriterion("product_attribute <", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeLessThanOrEqualTo(Byte value) {
            addCriterion("product_attribute <=", value, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeIn(List<Byte> values) {
            addCriterion("product_attribute in", values, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeNotIn(List<Byte> values) {
            addCriterion("product_attribute not in", values, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeBetween(Byte value1, Byte value2) {
            addCriterion("product_attribute between", value1, value2, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andProductAttributeNotBetween(Byte value1, Byte value2) {
            addCriterion("product_attribute not between", value1, value2, "productAttribute");
            return (Criteria) this;
        }

        public Criteria andItemBrandIsNull() {
            addCriterion("item_brand is null");
            return (Criteria) this;
        }

        public Criteria andItemBrandIsNotNull() {
            addCriterion("item_brand is not null");
            return (Criteria) this;
        }

        public Criteria andItemBrandEqualTo(String value) {
            addCriterion("item_brand =", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandNotEqualTo(String value) {
            addCriterion("item_brand <>", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandGreaterThan(String value) {
            addCriterion("item_brand >", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandGreaterThanOrEqualTo(String value) {
            addCriterion("item_brand >=", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandLessThan(String value) {
            addCriterion("item_brand <", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandLessThanOrEqualTo(String value) {
            addCriterion("item_brand <=", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandLike(String value) {
            addCriterion("item_brand like", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandNotLike(String value) {
            addCriterion("item_brand not like", value, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandIn(List<String> values) {
            addCriterion("item_brand in", values, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandNotIn(List<String> values) {
            addCriterion("item_brand not in", values, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandBetween(String value1, String value2) {
            addCriterion("item_brand between", value1, value2, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemBrandNotBetween(String value1, String value2) {
            addCriterion("item_brand not between", value1, value2, "itemBrand");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIsNull() {
            addCriterion("item_category is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIsNotNull() {
            addCriterion("item_category is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryEqualTo(String value) {
            addCriterion("item_category =", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotEqualTo(String value) {
            addCriterion("item_category <>", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryGreaterThan(String value) {
            addCriterion("item_category >", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("item_category >=", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLessThan(String value) {
            addCriterion("item_category <", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLessThanOrEqualTo(String value) {
            addCriterion("item_category <=", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryLike(String value) {
            addCriterion("item_category like", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotLike(String value) {
            addCriterion("item_category not like", value, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIn(List<String> values) {
            addCriterion("item_category in", values, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotIn(List<String> values) {
            addCriterion("item_category not in", values, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryBetween(String value1, String value2) {
            addCriterion("item_category between", value1, value2, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andItemCategoryNotBetween(String value1, String value2) {
            addCriterion("item_category not between", value1, value2, "itemCategory");
            return (Criteria) this;
        }

        public Criteria andSpecCodeIsNull() {
            addCriterion("spec_code is null");
            return (Criteria) this;
        }

        public Criteria andSpecCodeIsNotNull() {
            addCriterion("spec_code is not null");
            return (Criteria) this;
        }

        public Criteria andSpecCodeEqualTo(String value) {
            addCriterion("spec_code =", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeNotEqualTo(String value) {
            addCriterion("spec_code <>", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeGreaterThan(String value) {
            addCriterion("spec_code >", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeGreaterThanOrEqualTo(String value) {
            addCriterion("spec_code >=", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeLessThan(String value) {
            addCriterion("spec_code <", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeLessThanOrEqualTo(String value) {
            addCriterion("spec_code <=", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeLike(String value) {
            addCriterion("spec_code like", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeNotLike(String value) {
            addCriterion("spec_code not like", value, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeIn(List<String> values) {
            addCriterion("spec_code in", values, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeNotIn(List<String> values) {
            addCriterion("spec_code not in", values, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeBetween(String value1, String value2) {
            addCriterion("spec_code between", value1, value2, "specCode");
            return (Criteria) this;
        }

        public Criteria andSpecCodeNotBetween(String value1, String value2) {
            addCriterion("spec_code not between", value1, value2, "specCode");
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

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Date value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Date value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Date value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Date value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Date> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Date> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
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