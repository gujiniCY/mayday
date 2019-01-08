package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThemeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ThemeExample() {
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andThemeNameIsNull() {
			addCriterion("theme_name is null");
			return (Criteria) this;
		}

		public Criteria andThemeNameIsNotNull() {
			addCriterion("theme_name is not null");
			return (Criteria) this;
		}

		public Criteria andThemeNameEqualTo(String value) {
			addCriterion("theme_name =", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameNotEqualTo(String value) {
			addCriterion("theme_name <>", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameGreaterThan(String value) {
			addCriterion("theme_name >", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameGreaterThanOrEqualTo(String value) {
			addCriterion("theme_name >=", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameLessThan(String value) {
			addCriterion("theme_name <", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameLessThanOrEqualTo(String value) {
			addCriterion("theme_name <=", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameLike(String value) {
			addCriterion("theme_name like", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameNotLike(String value) {
			addCriterion("theme_name not like", value, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameIn(List<String> values) {
			addCriterion("theme_name in", values, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameNotIn(List<String> values) {
			addCriterion("theme_name not in", values, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameBetween(String value1, String value2) {
			addCriterion("theme_name between", value1, value2, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeNameNotBetween(String value1, String value2) {
			addCriterion("theme_name not between", value1, value2, "themeName");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeIsNull() {
			addCriterion("theme_describe is null");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeIsNotNull() {
			addCriterion("theme_describe is not null");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeEqualTo(String value) {
			addCriterion("theme_describe =", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeNotEqualTo(String value) {
			addCriterion("theme_describe <>", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeGreaterThan(String value) {
			addCriterion("theme_describe >", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("theme_describe >=", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeLessThan(String value) {
			addCriterion("theme_describe <", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeLessThanOrEqualTo(String value) {
			addCriterion("theme_describe <=", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeLike(String value) {
			addCriterion("theme_describe like", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeNotLike(String value) {
			addCriterion("theme_describe not like", value, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeIn(List<String> values) {
			addCriterion("theme_describe in", values, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeNotIn(List<String> values) {
			addCriterion("theme_describe not in", values, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeBetween(String value1, String value2) {
			addCriterion("theme_describe between", value1, value2, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeDescribeNotBetween(String value1, String value2) {
			addCriterion("theme_describe not between", value1, value2, "themeDescribe");
			return (Criteria) this;
		}

		public Criteria andThemeImgIsNull() {
			addCriterion("theme_img is null");
			return (Criteria) this;
		}

		public Criteria andThemeImgIsNotNull() {
			addCriterion("theme_img is not null");
			return (Criteria) this;
		}

		public Criteria andThemeImgEqualTo(String value) {
			addCriterion("theme_img =", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgNotEqualTo(String value) {
			addCriterion("theme_img <>", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgGreaterThan(String value) {
			addCriterion("theme_img >", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgGreaterThanOrEqualTo(String value) {
			addCriterion("theme_img >=", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgLessThan(String value) {
			addCriterion("theme_img <", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgLessThanOrEqualTo(String value) {
			addCriterion("theme_img <=", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgLike(String value) {
			addCriterion("theme_img like", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgNotLike(String value) {
			addCriterion("theme_img not like", value, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgIn(List<String> values) {
			addCriterion("theme_img in", values, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgNotIn(List<String> values) {
			addCriterion("theme_img not in", values, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgBetween(String value1, String value2) {
			addCriterion("theme_img between", value1, value2, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeImgNotBetween(String value1, String value2) {
			addCriterion("theme_img not between", value1, value2, "themeImg");
			return (Criteria) this;
		}

		public Criteria andThemeStatusIsNull() {
			addCriterion("theme_status is null");
			return (Criteria) this;
		}

		public Criteria andThemeStatusIsNotNull() {
			addCriterion("theme_status is not null");
			return (Criteria) this;
		}

		public Criteria andThemeStatusEqualTo(Integer value) {
			addCriterion("theme_status =", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusNotEqualTo(Integer value) {
			addCriterion("theme_status <>", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusGreaterThan(Integer value) {
			addCriterion("theme_status >", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("theme_status >=", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusLessThan(Integer value) {
			addCriterion("theme_status <", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusLessThanOrEqualTo(Integer value) {
			addCriterion("theme_status <=", value, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusIn(List<Integer> values) {
			addCriterion("theme_status in", values, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusNotIn(List<Integer> values) {
			addCriterion("theme_status not in", values, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusBetween(Integer value1, Integer value2) {
			addCriterion("theme_status between", value1, value2, "themeStatus");
			return (Criteria) this;
		}

		public Criteria andThemeStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("theme_status not between", value1, value2, "themeStatus");
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