package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public LogExample() {
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

		public Criteria andLogIdIsNull() {
			addCriterion("log_id is null");
			return (Criteria) this;
		}

		public Criteria andLogIdIsNotNull() {
			addCriterion("log_id is not null");
			return (Criteria) this;
		}

		public Criteria andLogIdEqualTo(Integer value) {
			addCriterion("log_id =", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdNotEqualTo(Integer value) {
			addCriterion("log_id <>", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdGreaterThan(Integer value) {
			addCriterion("log_id >", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("log_id >=", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdLessThan(Integer value) {
			addCriterion("log_id <", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdLessThanOrEqualTo(Integer value) {
			addCriterion("log_id <=", value, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdIn(List<Integer> values) {
			addCriterion("log_id in", values, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdNotIn(List<Integer> values) {
			addCriterion("log_id not in", values, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdBetween(Integer value1, Integer value2) {
			addCriterion("log_id between", value1, value2, "logId");
			return (Criteria) this;
		}

		public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
			addCriterion("log_id not between", value1, value2, "logId");
			return (Criteria) this;
		}

		public Criteria andLogTitleIsNull() {
			addCriterion("log_title is null");
			return (Criteria) this;
		}

		public Criteria andLogTitleIsNotNull() {
			addCriterion("log_title is not null");
			return (Criteria) this;
		}

		public Criteria andLogTitleEqualTo(String value) {
			addCriterion("log_title =", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleNotEqualTo(String value) {
			addCriterion("log_title <>", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleGreaterThan(String value) {
			addCriterion("log_title >", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleGreaterThanOrEqualTo(String value) {
			addCriterion("log_title >=", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleLessThan(String value) {
			addCriterion("log_title <", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleLessThanOrEqualTo(String value) {
			addCriterion("log_title <=", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleLike(String value) {
			addCriterion("log_title like", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleNotLike(String value) {
			addCriterion("log_title not like", value, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleIn(List<String> values) {
			addCriterion("log_title in", values, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleNotIn(List<String> values) {
			addCriterion("log_title not in", values, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleBetween(String value1, String value2) {
			addCriterion("log_title between", value1, value2, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogTitleNotBetween(String value1, String value2) {
			addCriterion("log_title not between", value1, value2, "logTitle");
			return (Criteria) this;
		}

		public Criteria andLogContentIsNull() {
			addCriterion("log_content is null");
			return (Criteria) this;
		}

		public Criteria andLogContentIsNotNull() {
			addCriterion("log_content is not null");
			return (Criteria) this;
		}

		public Criteria andLogContentEqualTo(String value) {
			addCriterion("log_content =", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentNotEqualTo(String value) {
			addCriterion("log_content <>", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentGreaterThan(String value) {
			addCriterion("log_content >", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentGreaterThanOrEqualTo(String value) {
			addCriterion("log_content >=", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentLessThan(String value) {
			addCriterion("log_content <", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentLessThanOrEqualTo(String value) {
			addCriterion("log_content <=", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentLike(String value) {
			addCriterion("log_content like", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentNotLike(String value) {
			addCriterion("log_content not like", value, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentIn(List<String> values) {
			addCriterion("log_content in", values, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentNotIn(List<String> values) {
			addCriterion("log_content not in", values, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentBetween(String value1, String value2) {
			addCriterion("log_content between", value1, value2, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogContentNotBetween(String value1, String value2) {
			addCriterion("log_content not between", value1, value2, "logContent");
			return (Criteria) this;
		}

		public Criteria andLogIpIsNull() {
			addCriterion("log_ip is null");
			return (Criteria) this;
		}

		public Criteria andLogIpIsNotNull() {
			addCriterion("log_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLogIpEqualTo(String value) {
			addCriterion("log_ip =", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpNotEqualTo(String value) {
			addCriterion("log_ip <>", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpGreaterThan(String value) {
			addCriterion("log_ip >", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpGreaterThanOrEqualTo(String value) {
			addCriterion("log_ip >=", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpLessThan(String value) {
			addCriterion("log_ip <", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpLessThanOrEqualTo(String value) {
			addCriterion("log_ip <=", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpLike(String value) {
			addCriterion("log_ip like", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpNotLike(String value) {
			addCriterion("log_ip not like", value, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpIn(List<String> values) {
			addCriterion("log_ip in", values, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpNotIn(List<String> values) {
			addCriterion("log_ip not in", values, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpBetween(String value1, String value2) {
			addCriterion("log_ip between", value1, value2, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogIpNotBetween(String value1, String value2) {
			addCriterion("log_ip not between", value1, value2, "logIp");
			return (Criteria) this;
		}

		public Criteria andLogDateIsNull() {
			addCriterion("log_date is null");
			return (Criteria) this;
		}

		public Criteria andLogDateIsNotNull() {
			addCriterion("log_date is not null");
			return (Criteria) this;
		}

		public Criteria andLogDateEqualTo(Date value) {
			addCriterion("log_date =", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateNotEqualTo(Date value) {
			addCriterion("log_date <>", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateGreaterThan(Date value) {
			addCriterion("log_date >", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateGreaterThanOrEqualTo(Date value) {
			addCriterion("log_date >=", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateLessThan(Date value) {
			addCriterion("log_date <", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateLessThanOrEqualTo(Date value) {
			addCriterion("log_date <=", value, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateIn(List<Date> values) {
			addCriterion("log_date in", values, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateNotIn(List<Date> values) {
			addCriterion("log_date not in", values, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateBetween(Date value1, Date value2) {
			addCriterion("log_date between", value1, value2, "logDate");
			return (Criteria) this;
		}

		public Criteria andLogDateNotBetween(Date value1, Date value2) {
			addCriterion("log_date not between", value1, value2, "logDate");
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