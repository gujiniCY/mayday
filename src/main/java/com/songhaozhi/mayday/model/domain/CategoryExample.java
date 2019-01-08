package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public CategoryExample() {
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

		public Criteria andCategoryIdIsNull() {
			addCriterion("category_id is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("category_id is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdEqualTo(Integer value) {
			addCriterion("category_id =", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotEqualTo(Integer value) {
			addCriterion("category_id <>", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThan(Integer value) {
			addCriterion("category_id >", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("category_id >=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThan(Integer value) {
			addCriterion("category_id <", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("category_id <=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIn(List<Integer> values) {
			addCriterion("category_id in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotIn(List<Integer> values) {
			addCriterion("category_id not in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("category_id between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("category_id not between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIsNull() {
			addCriterion("category_name is null");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIsNotNull() {
			addCriterion("category_name is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryNameEqualTo(String value) {
			addCriterion("category_name =", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotEqualTo(String value) {
			addCriterion("category_name <>", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameGreaterThan(String value) {
			addCriterion("category_name >", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
			addCriterion("category_name >=", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLessThan(String value) {
			addCriterion("category_name <", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLessThanOrEqualTo(String value) {
			addCriterion("category_name <=", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLike(String value) {
			addCriterion("category_name like", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotLike(String value) {
			addCriterion("category_name not like", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIn(List<String> values) {
			addCriterion("category_name in", values, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotIn(List<String> values) {
			addCriterion("category_name not in", values, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameBetween(String value1, String value2) {
			addCriterion("category_name between", value1, value2, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotBetween(String value1, String value2) {
			addCriterion("category_name not between", value1, value2, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlIsNull() {
			addCriterion("category_url is null");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlIsNotNull() {
			addCriterion("category_url is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlEqualTo(String value) {
			addCriterion("category_url =", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlNotEqualTo(String value) {
			addCriterion("category_url <>", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlGreaterThan(String value) {
			addCriterion("category_url >", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlGreaterThanOrEqualTo(String value) {
			addCriterion("category_url >=", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlLessThan(String value) {
			addCriterion("category_url <", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlLessThanOrEqualTo(String value) {
			addCriterion("category_url <=", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlLike(String value) {
			addCriterion("category_url like", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlNotLike(String value) {
			addCriterion("category_url not like", value, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlIn(List<String> values) {
			addCriterion("category_url in", values, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlNotIn(List<String> values) {
			addCriterion("category_url not in", values, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlBetween(String value1, String value2) {
			addCriterion("category_url between", value1, value2, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryUrlNotBetween(String value1, String value2) {
			addCriterion("category_url not between", value1, value2, "categoryUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeIsNull() {
			addCriterion("category_describe is null");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeIsNotNull() {
			addCriterion("category_describe is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeEqualTo(String value) {
			addCriterion("category_describe =", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeNotEqualTo(String value) {
			addCriterion("category_describe <>", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeGreaterThan(String value) {
			addCriterion("category_describe >", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("category_describe >=", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeLessThan(String value) {
			addCriterion("category_describe <", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeLessThanOrEqualTo(String value) {
			addCriterion("category_describe <=", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeLike(String value) {
			addCriterion("category_describe like", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeNotLike(String value) {
			addCriterion("category_describe not like", value, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeIn(List<String> values) {
			addCriterion("category_describe in", values, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeNotIn(List<String> values) {
			addCriterion("category_describe not in", values, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeBetween(String value1, String value2) {
			addCriterion("category_describe between", value1, value2, "categoryDescribe");
			return (Criteria) this;
		}

		public Criteria andCategoryDescribeNotBetween(String value1, String value2) {
			addCriterion("category_describe not between", value1, value2, "categoryDescribe");
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