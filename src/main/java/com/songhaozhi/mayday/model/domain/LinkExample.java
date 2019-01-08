package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.List;

public class LinkExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public LinkExample() {
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

		public Criteria andLinkIdIsNull() {
			addCriterion("link_id is null");
			return (Criteria) this;
		}

		public Criteria andLinkIdIsNotNull() {
			addCriterion("link_id is not null");
			return (Criteria) this;
		}

		public Criteria andLinkIdEqualTo(Integer value) {
			addCriterion("link_id =", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdNotEqualTo(Integer value) {
			addCriterion("link_id <>", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdGreaterThan(Integer value) {
			addCriterion("link_id >", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("link_id >=", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdLessThan(Integer value) {
			addCriterion("link_id <", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdLessThanOrEqualTo(Integer value) {
			addCriterion("link_id <=", value, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdIn(List<Integer> values) {
			addCriterion("link_id in", values, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdNotIn(List<Integer> values) {
			addCriterion("link_id not in", values, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdBetween(Integer value1, Integer value2) {
			addCriterion("link_id between", value1, value2, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkIdNotBetween(Integer value1, Integer value2) {
			addCriterion("link_id not between", value1, value2, "linkId");
			return (Criteria) this;
		}

		public Criteria andLinkNameIsNull() {
			addCriterion("link_name is null");
			return (Criteria) this;
		}

		public Criteria andLinkNameIsNotNull() {
			addCriterion("link_name is not null");
			return (Criteria) this;
		}

		public Criteria andLinkNameEqualTo(String value) {
			addCriterion("link_name =", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotEqualTo(String value) {
			addCriterion("link_name <>", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameGreaterThan(String value) {
			addCriterion("link_name >", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
			addCriterion("link_name >=", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLessThan(String value) {
			addCriterion("link_name <", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLessThanOrEqualTo(String value) {
			addCriterion("link_name <=", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameLike(String value) {
			addCriterion("link_name like", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotLike(String value) {
			addCriterion("link_name not like", value, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameIn(List<String> values) {
			addCriterion("link_name in", values, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotIn(List<String> values) {
			addCriterion("link_name not in", values, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameBetween(String value1, String value2) {
			addCriterion("link_name between", value1, value2, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkNameNotBetween(String value1, String value2) {
			addCriterion("link_name not between", value1, value2, "linkName");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNull() {
			addCriterion("link_url is null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIsNotNull() {
			addCriterion("link_url is not null");
			return (Criteria) this;
		}

		public Criteria andLinkUrlEqualTo(String value) {
			addCriterion("link_url =", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotEqualTo(String value) {
			addCriterion("link_url <>", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThan(String value) {
			addCriterion("link_url >", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
			addCriterion("link_url >=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThan(String value) {
			addCriterion("link_url <", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLessThanOrEqualTo(String value) {
			addCriterion("link_url <=", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlLike(String value) {
			addCriterion("link_url like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotLike(String value) {
			addCriterion("link_url not like", value, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlIn(List<String> values) {
			addCriterion("link_url in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotIn(List<String> values) {
			addCriterion("link_url not in", values, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlBetween(String value1, String value2) {
			addCriterion("link_url between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkUrlNotBetween(String value1, String value2) {
			addCriterion("link_url not between", value1, value2, "linkUrl");
			return (Criteria) this;
		}

		public Criteria andLinkLogoIsNull() {
			addCriterion("link_logo is null");
			return (Criteria) this;
		}

		public Criteria andLinkLogoIsNotNull() {
			addCriterion("link_logo is not null");
			return (Criteria) this;
		}

		public Criteria andLinkLogoEqualTo(String value) {
			addCriterion("link_logo =", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoNotEqualTo(String value) {
			addCriterion("link_logo <>", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoGreaterThan(String value) {
			addCriterion("link_logo >", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoGreaterThanOrEqualTo(String value) {
			addCriterion("link_logo >=", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoLessThan(String value) {
			addCriterion("link_logo <", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoLessThanOrEqualTo(String value) {
			addCriterion("link_logo <=", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoLike(String value) {
			addCriterion("link_logo like", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoNotLike(String value) {
			addCriterion("link_logo not like", value, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoIn(List<String> values) {
			addCriterion("link_logo in", values, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoNotIn(List<String> values) {
			addCriterion("link_logo not in", values, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoBetween(String value1, String value2) {
			addCriterion("link_logo between", value1, value2, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkLogoNotBetween(String value1, String value2) {
			addCriterion("link_logo not between", value1, value2, "linkLogo");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeIsNull() {
			addCriterion("link_describe is null");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeIsNotNull() {
			addCriterion("link_describe is not null");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeEqualTo(String value) {
			addCriterion("link_describe =", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeNotEqualTo(String value) {
			addCriterion("link_describe <>", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeGreaterThan(String value) {
			addCriterion("link_describe >", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("link_describe >=", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeLessThan(String value) {
			addCriterion("link_describe <", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeLessThanOrEqualTo(String value) {
			addCriterion("link_describe <=", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeLike(String value) {
			addCriterion("link_describe like", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeNotLike(String value) {
			addCriterion("link_describe not like", value, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeIn(List<String> values) {
			addCriterion("link_describe in", values, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeNotIn(List<String> values) {
			addCriterion("link_describe not in", values, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeBetween(String value1, String value2) {
			addCriterion("link_describe between", value1, value2, "linkDescribe");
			return (Criteria) this;
		}

		public Criteria andLinkDescribeNotBetween(String value1, String value2) {
			addCriterion("link_describe not between", value1, value2, "linkDescribe");
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