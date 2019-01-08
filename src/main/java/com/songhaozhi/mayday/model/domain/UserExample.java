package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLoginEnableIsNull() {
            addCriterion("login_enable is null");
            return (Criteria) this;
        }

        public Criteria andLoginEnableIsNotNull() {
            addCriterion("login_enable is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEnableEqualTo(String value) {
            addCriterion("login_enable =", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableNotEqualTo(String value) {
            addCriterion("login_enable <>", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableGreaterThan(String value) {
            addCriterion("login_enable >", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableGreaterThanOrEqualTo(String value) {
            addCriterion("login_enable >=", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableLessThan(String value) {
            addCriterion("login_enable <", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableLessThanOrEqualTo(String value) {
            addCriterion("login_enable <=", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableLike(String value) {
            addCriterion("login_enable like", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableNotLike(String value) {
            addCriterion("login_enable not like", value, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableIn(List<String> values) {
            addCriterion("login_enable in", values, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableNotIn(List<String> values) {
            addCriterion("login_enable not in", values, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableBetween(String value1, String value2) {
            addCriterion("login_enable between", value1, value2, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginEnableNotBetween(String value1, String value2) {
            addCriterion("login_enable not between", value1, value2, "loginEnable");
            return (Criteria) this;
        }

        public Criteria andLoginErrorIsNull() {
            addCriterion("login_error is null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorIsNotNull() {
            addCriterion("login_error is not null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorEqualTo(Integer value) {
            addCriterion("login_error =", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNotEqualTo(Integer value) {
            addCriterion("login_error <>", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorGreaterThan(Integer value) {
            addCriterion("login_error >", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_error >=", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorLessThan(Integer value) {
            addCriterion("login_error <", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorLessThanOrEqualTo(Integer value) {
            addCriterion("login_error <=", value, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorIn(List<Integer> values) {
            addCriterion("login_error in", values, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNotIn(List<Integer> values) {
            addCriterion("login_error not in", values, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorBetween(Integer value1, Integer value2) {
            addCriterion("login_error between", value1, value2, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginErrorNotBetween(Integer value1, Integer value2) {
            addCriterion("login_error not between", value1, value2, "loginError");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIsNull() {
            addCriterion("login_last_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIsNotNull() {
            addCriterion("login_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeEqualTo(Date value) {
            addCriterion("login_last_time =", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotEqualTo(Date value) {
            addCriterion("login_last_time <>", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeGreaterThan(Date value) {
            addCriterion("login_last_time >", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_last_time >=", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeLessThan(Date value) {
            addCriterion("login_last_time <", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_last_time <=", value, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeIn(List<Date> values) {
            addCriterion("login_last_time in", values, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotIn(List<Date> values) {
            addCriterion("login_last_time not in", values, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeBetween(Date value1, Date value2) {
            addCriterion("login_last_time between", value1, value2, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andLoginLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_last_time not between", value1, value2, "loginLastTime");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIsNull() {
            addCriterion("user_portrait is null");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIsNotNull() {
            addCriterion("user_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andUserPortraitEqualTo(String value) {
            addCriterion("user_portrait =", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitNotEqualTo(String value) {
            addCriterion("user_portrait <>", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitGreaterThan(String value) {
            addCriterion("user_portrait >", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitGreaterThanOrEqualTo(String value) {
            addCriterion("user_portrait >=", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitLessThan(String value) {
            addCriterion("user_portrait <", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitLessThanOrEqualTo(String value) {
            addCriterion("user_portrait <=", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitLike(String value) {
            addCriterion("user_portrait like", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitNotLike(String value) {
            addCriterion("user_portrait not like", value, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitIn(List<String> values) {
            addCriterion("user_portrait in", values, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitNotIn(List<String> values) {
            addCriterion("user_portrait not in", values, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitBetween(String value1, String value2) {
            addCriterion("user_portrait between", value1, value2, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserPortraitNotBetween(String value1, String value2) {
            addCriterion("user_portrait not between", value1, value2, "userPortrait");
            return (Criteria) this;
        }

        public Criteria andUserExplainIsNull() {
            addCriterion("user_explain is null");
            return (Criteria) this;
        }

        public Criteria andUserExplainIsNotNull() {
            addCriterion("user_explain is not null");
            return (Criteria) this;
        }

        public Criteria andUserExplainEqualTo(String value) {
            addCriterion("user_explain =", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainNotEqualTo(String value) {
            addCriterion("user_explain <>", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainGreaterThan(String value) {
            addCriterion("user_explain >", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainGreaterThanOrEqualTo(String value) {
            addCriterion("user_explain >=", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainLessThan(String value) {
            addCriterion("user_explain <", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainLessThanOrEqualTo(String value) {
            addCriterion("user_explain <=", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainLike(String value) {
            addCriterion("user_explain like", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainNotLike(String value) {
            addCriterion("user_explain not like", value, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainIn(List<String> values) {
            addCriterion("user_explain in", values, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainNotIn(List<String> values) {
            addCriterion("user_explain not in", values, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainBetween(String value1, String value2) {
            addCriterion("user_explain between", value1, value2, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserExplainNotBetween(String value1, String value2) {
            addCriterion("user_explain not between", value1, value2, "userExplain");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameIsNull() {
            addCriterion("user_display_name is null");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameIsNotNull() {
            addCriterion("user_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameEqualTo(String value) {
            addCriterion("user_display_name =", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameNotEqualTo(String value) {
            addCriterion("user_display_name <>", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameGreaterThan(String value) {
            addCriterion("user_display_name >", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_display_name >=", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameLessThan(String value) {
            addCriterion("user_display_name <", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("user_display_name <=", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameLike(String value) {
            addCriterion("user_display_name like", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameNotLike(String value) {
            addCriterion("user_display_name not like", value, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameIn(List<String> values) {
            addCriterion("user_display_name in", values, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameNotIn(List<String> values) {
            addCriterion("user_display_name not in", values, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameBetween(String value1, String value2) {
            addCriterion("user_display_name between", value1, value2, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserDisplayNameNotBetween(String value1, String value2) {
            addCriterion("user_display_name not between", value1, value2, "userDisplayName");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
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