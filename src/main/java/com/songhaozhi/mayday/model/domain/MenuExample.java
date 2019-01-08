package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MenuExample() {
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

		public Criteria andMenuIdIsNull() {
			addCriterion("menu_id is null");
			return (Criteria) this;
		}

		public Criteria andMenuIdIsNotNull() {
			addCriterion("menu_id is not null");
			return (Criteria) this;
		}

		public Criteria andMenuIdEqualTo(Integer value) {
			addCriterion("menu_id =", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdNotEqualTo(Integer value) {
			addCriterion("menu_id <>", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdGreaterThan(Integer value) {
			addCriterion("menu_id >", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("menu_id >=", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdLessThan(Integer value) {
			addCriterion("menu_id <", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
			addCriterion("menu_id <=", value, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdIn(List<Integer> values) {
			addCriterion("menu_id in", values, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdNotIn(List<Integer> values) {
			addCriterion("menu_id not in", values, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdBetween(Integer value1, Integer value2) {
			addCriterion("menu_id between", value1, value2, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
			addCriterion("menu_id not between", value1, value2, "menuId");
			return (Criteria) this;
		}

		public Criteria andMenuIconIsNull() {
			addCriterion("menu_icon is null");
			return (Criteria) this;
		}

		public Criteria andMenuIconIsNotNull() {
			addCriterion("menu_icon is not null");
			return (Criteria) this;
		}

		public Criteria andMenuIconEqualTo(String value) {
			addCriterion("menu_icon =", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconNotEqualTo(String value) {
			addCriterion("menu_icon <>", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconGreaterThan(String value) {
			addCriterion("menu_icon >", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
			addCriterion("menu_icon >=", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconLessThan(String value) {
			addCriterion("menu_icon <", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconLessThanOrEqualTo(String value) {
			addCriterion("menu_icon <=", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconLike(String value) {
			addCriterion("menu_icon like", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconNotLike(String value) {
			addCriterion("menu_icon not like", value, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconIn(List<String> values) {
			addCriterion("menu_icon in", values, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconNotIn(List<String> values) {
			addCriterion("menu_icon not in", values, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconBetween(String value1, String value2) {
			addCriterion("menu_icon between", value1, value2, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuIconNotBetween(String value1, String value2) {
			addCriterion("menu_icon not between", value1, value2, "menuIcon");
			return (Criteria) this;
		}

		public Criteria andMenuNameIsNull() {
			addCriterion("menu_name is null");
			return (Criteria) this;
		}

		public Criteria andMenuNameIsNotNull() {
			addCriterion("menu_name is not null");
			return (Criteria) this;
		}

		public Criteria andMenuNameEqualTo(String value) {
			addCriterion("menu_name =", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotEqualTo(String value) {
			addCriterion("menu_name <>", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameGreaterThan(String value) {
			addCriterion("menu_name >", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
			addCriterion("menu_name >=", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLessThan(String value) {
			addCriterion("menu_name <", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLessThanOrEqualTo(String value) {
			addCriterion("menu_name <=", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLike(String value) {
			addCriterion("menu_name like", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotLike(String value) {
			addCriterion("menu_name not like", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameIn(List<String> values) {
			addCriterion("menu_name in", values, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotIn(List<String> values) {
			addCriterion("menu_name not in", values, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameBetween(String value1, String value2) {
			addCriterion("menu_name between", value1, value2, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotBetween(String value1, String value2) {
			addCriterion("menu_name not between", value1, value2, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuSortIsNull() {
			addCriterion("menu_sort is null");
			return (Criteria) this;
		}

		public Criteria andMenuSortIsNotNull() {
			addCriterion("menu_sort is not null");
			return (Criteria) this;
		}

		public Criteria andMenuSortEqualTo(Integer value) {
			addCriterion("menu_sort =", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortNotEqualTo(Integer value) {
			addCriterion("menu_sort <>", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortGreaterThan(Integer value) {
			addCriterion("menu_sort >", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("menu_sort >=", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortLessThan(Integer value) {
			addCriterion("menu_sort <", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortLessThanOrEqualTo(Integer value) {
			addCriterion("menu_sort <=", value, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortIn(List<Integer> values) {
			addCriterion("menu_sort in", values, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortNotIn(List<Integer> values) {
			addCriterion("menu_sort not in", values, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortBetween(Integer value1, Integer value2) {
			addCriterion("menu_sort between", value1, value2, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuSortNotBetween(Integer value1, Integer value2) {
			addCriterion("menu_sort not between", value1, value2, "menuSort");
			return (Criteria) this;
		}

		public Criteria andMenuTargetIsNull() {
			addCriterion("menu_target is null");
			return (Criteria) this;
		}

		public Criteria andMenuTargetIsNotNull() {
			addCriterion("menu_target is not null");
			return (Criteria) this;
		}

		public Criteria andMenuTargetEqualTo(String value) {
			addCriterion("menu_target =", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetNotEqualTo(String value) {
			addCriterion("menu_target <>", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetGreaterThan(String value) {
			addCriterion("menu_target >", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetGreaterThanOrEqualTo(String value) {
			addCriterion("menu_target >=", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetLessThan(String value) {
			addCriterion("menu_target <", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetLessThanOrEqualTo(String value) {
			addCriterion("menu_target <=", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetLike(String value) {
			addCriterion("menu_target like", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetNotLike(String value) {
			addCriterion("menu_target not like", value, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetIn(List<String> values) {
			addCriterion("menu_target in", values, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetNotIn(List<String> values) {
			addCriterion("menu_target not in", values, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetBetween(String value1, String value2) {
			addCriterion("menu_target between", value1, value2, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuTargetNotBetween(String value1, String value2) {
			addCriterion("menu_target not between", value1, value2, "menuTarget");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIsNull() {
			addCriterion("menu_url is null");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIsNotNull() {
			addCriterion("menu_url is not null");
			return (Criteria) this;
		}

		public Criteria andMenuUrlEqualTo(String value) {
			addCriterion("menu_url =", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotEqualTo(String value) {
			addCriterion("menu_url <>", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlGreaterThan(String value) {
			addCriterion("menu_url >", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
			addCriterion("menu_url >=", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLessThan(String value) {
			addCriterion("menu_url <", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLessThanOrEqualTo(String value) {
			addCriterion("menu_url <=", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLike(String value) {
			addCriterion("menu_url like", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotLike(String value) {
			addCriterion("menu_url not like", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIn(List<String> values) {
			addCriterion("menu_url in", values, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotIn(List<String> values) {
			addCriterion("menu_url not in", values, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlBetween(String value1, String value2) {
			addCriterion("menu_url between", value1, value2, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotBetween(String value1, String value2) {
			addCriterion("menu_url not between", value1, value2, "menuUrl");
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