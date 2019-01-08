package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.List;

public class AttachmentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public AttachmentExample() {
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

		public Criteria andPictureNameIsNull() {
			addCriterion("picture_name is null");
			return (Criteria) this;
		}

		public Criteria andPictureNameIsNotNull() {
			addCriterion("picture_name is not null");
			return (Criteria) this;
		}

		public Criteria andPictureNameEqualTo(String value) {
			addCriterion("picture_name =", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameNotEqualTo(String value) {
			addCriterion("picture_name <>", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameGreaterThan(String value) {
			addCriterion("picture_name >", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameGreaterThanOrEqualTo(String value) {
			addCriterion("picture_name >=", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameLessThan(String value) {
			addCriterion("picture_name <", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameLessThanOrEqualTo(String value) {
			addCriterion("picture_name <=", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameLike(String value) {
			addCriterion("picture_name like", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameNotLike(String value) {
			addCriterion("picture_name not like", value, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameIn(List<String> values) {
			addCriterion("picture_name in", values, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameNotIn(List<String> values) {
			addCriterion("picture_name not in", values, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameBetween(String value1, String value2) {
			addCriterion("picture_name between", value1, value2, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPictureNameNotBetween(String value1, String value2) {
			addCriterion("picture_name not between", value1, value2, "pictureName");
			return (Criteria) this;
		}

		public Criteria andPicturePathIsNull() {
			addCriterion("picture_path is null");
			return (Criteria) this;
		}

		public Criteria andPicturePathIsNotNull() {
			addCriterion("picture_path is not null");
			return (Criteria) this;
		}

		public Criteria andPicturePathEqualTo(String value) {
			addCriterion("picture_path =", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotEqualTo(String value) {
			addCriterion("picture_path <>", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathGreaterThan(String value) {
			addCriterion("picture_path >", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathGreaterThanOrEqualTo(String value) {
			addCriterion("picture_path >=", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLessThan(String value) {
			addCriterion("picture_path <", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLessThanOrEqualTo(String value) {
			addCriterion("picture_path <=", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathLike(String value) {
			addCriterion("picture_path like", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotLike(String value) {
			addCriterion("picture_path not like", value, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathIn(List<String> values) {
			addCriterion("picture_path in", values, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotIn(List<String> values) {
			addCriterion("picture_path not in", values, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathBetween(String value1, String value2) {
			addCriterion("picture_path between", value1, value2, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPicturePathNotBetween(String value1, String value2) {
			addCriterion("picture_path not between", value1, value2, "picturePath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathIsNull() {
			addCriterion("picture_small_path is null");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathIsNotNull() {
			addCriterion("picture_small_path is not null");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathEqualTo(String value) {
			addCriterion("picture_small_path =", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathNotEqualTo(String value) {
			addCriterion("picture_small_path <>", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathGreaterThan(String value) {
			addCriterion("picture_small_path >", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathGreaterThanOrEqualTo(String value) {
			addCriterion("picture_small_path >=", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathLessThan(String value) {
			addCriterion("picture_small_path <", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathLessThanOrEqualTo(String value) {
			addCriterion("picture_small_path <=", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathLike(String value) {
			addCriterion("picture_small_path like", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathNotLike(String value) {
			addCriterion("picture_small_path not like", value, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathIn(List<String> values) {
			addCriterion("picture_small_path in", values, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathNotIn(List<String> values) {
			addCriterion("picture_small_path not in", values, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathBetween(String value1, String value2) {
			addCriterion("picture_small_path between", value1, value2, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureSmallPathNotBetween(String value1, String value2) {
			addCriterion("picture_small_path not between", value1, value2, "pictureSmallPath");
			return (Criteria) this;
		}

		public Criteria andPictureTypeIsNull() {
			addCriterion("picture_type is null");
			return (Criteria) this;
		}

		public Criteria andPictureTypeIsNotNull() {
			addCriterion("picture_type is not null");
			return (Criteria) this;
		}

		public Criteria andPictureTypeEqualTo(String value) {
			addCriterion("picture_type =", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeNotEqualTo(String value) {
			addCriterion("picture_type <>", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeGreaterThan(String value) {
			addCriterion("picture_type >", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeGreaterThanOrEqualTo(String value) {
			addCriterion("picture_type >=", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeLessThan(String value) {
			addCriterion("picture_type <", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeLessThanOrEqualTo(String value) {
			addCriterion("picture_type <=", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeLike(String value) {
			addCriterion("picture_type like", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeNotLike(String value) {
			addCriterion("picture_type not like", value, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeIn(List<String> values) {
			addCriterion("picture_type in", values, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeNotIn(List<String> values) {
			addCriterion("picture_type not in", values, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeBetween(String value1, String value2) {
			addCriterion("picture_type between", value1, value2, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureTypeNotBetween(String value1, String value2) {
			addCriterion("picture_type not between", value1, value2, "pictureType");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateIsNull() {
			addCriterion("picture_create_date is null");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateIsNotNull() {
			addCriterion("picture_create_date is not null");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateEqualTo(String value) {
			addCriterion("picture_create_date =", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateNotEqualTo(String value) {
			addCriterion("picture_create_date <>", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateGreaterThan(String value) {
			addCriterion("picture_create_date >", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("picture_create_date >=", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateLessThan(String value) {
			addCriterion("picture_create_date <", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateLessThanOrEqualTo(String value) {
			addCriterion("picture_create_date <=", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateLike(String value) {
			addCriterion("picture_create_date like", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateNotLike(String value) {
			addCriterion("picture_create_date not like", value, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateIn(List<String> values) {
			addCriterion("picture_create_date in", values, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateNotIn(List<String> values) {
			addCriterion("picture_create_date not in", values, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateBetween(String value1, String value2) {
			addCriterion("picture_create_date between", value1, value2, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureCreateDateNotBetween(String value1, String value2) {
			addCriterion("picture_create_date not between", value1, value2, "pictureCreateDate");
			return (Criteria) this;
		}

		public Criteria andPictureSizeIsNull() {
			addCriterion("picture_size is null");
			return (Criteria) this;
		}

		public Criteria andPictureSizeIsNotNull() {
			addCriterion("picture_size is not null");
			return (Criteria) this;
		}

		public Criteria andPictureSizeEqualTo(String value) {
			addCriterion("picture_size =", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeNotEqualTo(String value) {
			addCriterion("picture_size <>", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeGreaterThan(String value) {
			addCriterion("picture_size >", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeGreaterThanOrEqualTo(String value) {
			addCriterion("picture_size >=", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeLessThan(String value) {
			addCriterion("picture_size <", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeLessThanOrEqualTo(String value) {
			addCriterion("picture_size <=", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeLike(String value) {
			addCriterion("picture_size like", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeNotLike(String value) {
			addCriterion("picture_size not like", value, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeIn(List<String> values) {
			addCriterion("picture_size in", values, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeNotIn(List<String> values) {
			addCriterion("picture_size not in", values, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeBetween(String value1, String value2) {
			addCriterion("picture_size between", value1, value2, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSizeNotBetween(String value1, String value2) {
			addCriterion("picture_size not between", value1, value2, "pictureSize");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixIsNull() {
			addCriterion("picture_suffix is null");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixIsNotNull() {
			addCriterion("picture_suffix is not null");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixEqualTo(String value) {
			addCriterion("picture_suffix =", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixNotEqualTo(String value) {
			addCriterion("picture_suffix <>", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixGreaterThan(String value) {
			addCriterion("picture_suffix >", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixGreaterThanOrEqualTo(String value) {
			addCriterion("picture_suffix >=", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixLessThan(String value) {
			addCriterion("picture_suffix <", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixLessThanOrEqualTo(String value) {
			addCriterion("picture_suffix <=", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixLike(String value) {
			addCriterion("picture_suffix like", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixNotLike(String value) {
			addCriterion("picture_suffix not like", value, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixIn(List<String> values) {
			addCriterion("picture_suffix in", values, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixNotIn(List<String> values) {
			addCriterion("picture_suffix not in", values, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixBetween(String value1, String value2) {
			addCriterion("picture_suffix between", value1, value2, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureSuffixNotBetween(String value1, String value2) {
			addCriterion("picture_suffix not between", value1, value2, "pictureSuffix");
			return (Criteria) this;
		}

		public Criteria andPictureWhIsNull() {
			addCriterion("picture_wh is null");
			return (Criteria) this;
		}

		public Criteria andPictureWhIsNotNull() {
			addCriterion("picture_wh is not null");
			return (Criteria) this;
		}

		public Criteria andPictureWhEqualTo(String value) {
			addCriterion("picture_wh =", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhNotEqualTo(String value) {
			addCriterion("picture_wh <>", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhGreaterThan(String value) {
			addCriterion("picture_wh >", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhGreaterThanOrEqualTo(String value) {
			addCriterion("picture_wh >=", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhLessThan(String value) {
			addCriterion("picture_wh <", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhLessThanOrEqualTo(String value) {
			addCriterion("picture_wh <=", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhLike(String value) {
			addCriterion("picture_wh like", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhNotLike(String value) {
			addCriterion("picture_wh not like", value, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhIn(List<String> values) {
			addCriterion("picture_wh in", values, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhNotIn(List<String> values) {
			addCriterion("picture_wh not in", values, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhBetween(String value1, String value2) {
			addCriterion("picture_wh between", value1, value2, "pictureWh");
			return (Criteria) this;
		}

		public Criteria andPictureWhNotBetween(String value1, String value2) {
			addCriterion("picture_wh not between", value1, value2, "pictureWh");
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