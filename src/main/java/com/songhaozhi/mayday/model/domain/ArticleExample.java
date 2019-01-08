package com.songhaozhi.mayday.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ArticleExample() {
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

		public Criteria andArticleContentIsNull() {
			addCriterion("article_content is null");
			return (Criteria) this;
		}

		public Criteria andArticleContentIsNotNull() {
			addCriterion("article_content is not null");
			return (Criteria) this;
		}

		public Criteria andArticleContentEqualTo(String value) {
			addCriterion("article_content =", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotEqualTo(String value) {
			addCriterion("article_content <>", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentGreaterThan(String value) {
			addCriterion("article_content >", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentGreaterThanOrEqualTo(String value) {
			addCriterion("article_content >=", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLessThan(String value) {
			addCriterion("article_content <", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLessThanOrEqualTo(String value) {
			addCriterion("article_content <=", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentLike(String value) {
			addCriterion("article_content like", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotLike(String value) {
			addCriterion("article_content not like", value, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentIn(List<String> values) {
			addCriterion("article_content in", values, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotIn(List<String> values) {
			addCriterion("article_content not in", values, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentBetween(String value1, String value2) {
			addCriterion("article_content between", value1, value2, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentNotBetween(String value1, String value2) {
			addCriterion("article_content not between", value1, value2, "articleContent");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdIsNull() {
			addCriterion("article_content_md is null");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdIsNotNull() {
			addCriterion("article_content_md is not null");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdEqualTo(String value) {
			addCriterion("article_content_md =", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdNotEqualTo(String value) {
			addCriterion("article_content_md <>", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdGreaterThan(String value) {
			addCriterion("article_content_md >", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdGreaterThanOrEqualTo(String value) {
			addCriterion("article_content_md >=", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdLessThan(String value) {
			addCriterion("article_content_md <", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdLessThanOrEqualTo(String value) {
			addCriterion("article_content_md <=", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdLike(String value) {
			addCriterion("article_content_md like", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdNotLike(String value) {
			addCriterion("article_content_md not like", value, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdIn(List<String> values) {
			addCriterion("article_content_md in", values, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdNotIn(List<String> values) {
			addCriterion("article_content_md not in", values, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdBetween(String value1, String value2) {
			addCriterion("article_content_md between", value1, value2, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleContentMdNotBetween(String value1, String value2) {
			addCriterion("article_content_md not between", value1, value2, "articleContentMd");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeIsNull() {
			addCriterion("article_newstime is null");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeIsNotNull() {
			addCriterion("article_newstime is not null");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeEqualTo(Date value) {
			addCriterion("article_newstime =", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeNotEqualTo(Date value) {
			addCriterion("article_newstime <>", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeGreaterThan(Date value) {
			addCriterion("article_newstime >", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeGreaterThanOrEqualTo(Date value) {
			addCriterion("article_newstime >=", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeLessThan(Date value) {
			addCriterion("article_newstime <", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeLessThanOrEqualTo(Date value) {
			addCriterion("article_newstime <=", value, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeIn(List<Date> values) {
			addCriterion("article_newstime in", values, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeNotIn(List<Date> values) {
			addCriterion("article_newstime not in", values, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeBetween(Date value1, Date value2) {
			addCriterion("article_newstime between", value1, value2, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleNewstimeNotBetween(Date value1, Date value2) {
			addCriterion("article_newstime not between", value1, value2, "articleNewstime");
			return (Criteria) this;
		}

		public Criteria andArticleStatusIsNull() {
			addCriterion("article_status is null");
			return (Criteria) this;
		}

		public Criteria andArticleStatusIsNotNull() {
			addCriterion("article_status is not null");
			return (Criteria) this;
		}

		public Criteria andArticleStatusEqualTo(Integer value) {
			addCriterion("article_status =", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusNotEqualTo(Integer value) {
			addCriterion("article_status <>", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusGreaterThan(Integer value) {
			addCriterion("article_status >", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_status >=", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusLessThan(Integer value) {
			addCriterion("article_status <", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusLessThanOrEqualTo(Integer value) {
			addCriterion("article_status <=", value, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusIn(List<Integer> values) {
			addCriterion("article_status in", values, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusNotIn(List<Integer> values) {
			addCriterion("article_status not in", values, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusBetween(Integer value1, Integer value2) {
			addCriterion("article_status between", value1, value2, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("article_status not between", value1, value2, "articleStatus");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryIsNull() {
			addCriterion("article_summary is null");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryIsNotNull() {
			addCriterion("article_summary is not null");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryEqualTo(String value) {
			addCriterion("article_summary =", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryNotEqualTo(String value) {
			addCriterion("article_summary <>", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryGreaterThan(String value) {
			addCriterion("article_summary >", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryGreaterThanOrEqualTo(String value) {
			addCriterion("article_summary >=", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryLessThan(String value) {
			addCriterion("article_summary <", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryLessThanOrEqualTo(String value) {
			addCriterion("article_summary <=", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryLike(String value) {
			addCriterion("article_summary like", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryNotLike(String value) {
			addCriterion("article_summary not like", value, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryIn(List<String> values) {
			addCriterion("article_summary in", values, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryNotIn(List<String> values) {
			addCriterion("article_summary not in", values, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryBetween(String value1, String value2) {
			addCriterion("article_summary between", value1, value2, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleSummaryNotBetween(String value1, String value2) {
			addCriterion("article_summary not between", value1, value2, "articleSummary");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailIsNull() {
			addCriterion("article_thumbnail is null");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailIsNotNull() {
			addCriterion("article_thumbnail is not null");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailEqualTo(String value) {
			addCriterion("article_thumbnail =", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailNotEqualTo(String value) {
			addCriterion("article_thumbnail <>", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailGreaterThan(String value) {
			addCriterion("article_thumbnail >", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailGreaterThanOrEqualTo(String value) {
			addCriterion("article_thumbnail >=", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailLessThan(String value) {
			addCriterion("article_thumbnail <", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailLessThanOrEqualTo(String value) {
			addCriterion("article_thumbnail <=", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailLike(String value) {
			addCriterion("article_thumbnail like", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailNotLike(String value) {
			addCriterion("article_thumbnail not like", value, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailIn(List<String> values) {
			addCriterion("article_thumbnail in", values, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailNotIn(List<String> values) {
			addCriterion("article_thumbnail not in", values, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailBetween(String value1, String value2) {
			addCriterion("article_thumbnail between", value1, value2, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleThumbnailNotBetween(String value1, String value2) {
			addCriterion("article_thumbnail not between", value1, value2, "articleThumbnail");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIsNull() {
			addCriterion("article_title is null");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIsNotNull() {
			addCriterion("article_title is not null");
			return (Criteria) this;
		}

		public Criteria andArticleTitleEqualTo(String value) {
			addCriterion("article_title =", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotEqualTo(String value) {
			addCriterion("article_title <>", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleGreaterThan(String value) {
			addCriterion("article_title >", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
			addCriterion("article_title >=", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLessThan(String value) {
			addCriterion("article_title <", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLessThanOrEqualTo(String value) {
			addCriterion("article_title <=", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleLike(String value) {
			addCriterion("article_title like", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotLike(String value) {
			addCriterion("article_title not like", value, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleIn(List<String> values) {
			addCriterion("article_title in", values, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotIn(List<String> values) {
			addCriterion("article_title not in", values, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleBetween(String value1, String value2) {
			addCriterion("article_title between", value1, value2, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTitleNotBetween(String value1, String value2) {
			addCriterion("article_title not between", value1, value2, "articleTitle");
			return (Criteria) this;
		}

		public Criteria andArticleTypeIsNull() {
			addCriterion("article_type is null");
			return (Criteria) this;
		}

		public Criteria andArticleTypeIsNotNull() {
			addCriterion("article_type is not null");
			return (Criteria) this;
		}

		public Criteria andArticleTypeEqualTo(Integer value) {
			addCriterion("article_type =", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeNotEqualTo(Integer value) {
			addCriterion("article_type <>", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeGreaterThan(Integer value) {
			addCriterion("article_type >", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_type >=", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeLessThan(Integer value) {
			addCriterion("article_type <", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeLessThanOrEqualTo(Integer value) {
			addCriterion("article_type <=", value, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeIn(List<Integer> values) {
			addCriterion("article_type in", values, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeNotIn(List<Integer> values) {
			addCriterion("article_type not in", values, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeBetween(Integer value1, Integer value2) {
			addCriterion("article_type between", value1, value2, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticleTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("article_type not between", value1, value2, "articleType");
			return (Criteria) this;
		}

		public Criteria andArticlePostIsNull() {
			addCriterion("article_post is null");
			return (Criteria) this;
		}

		public Criteria andArticlePostIsNotNull() {
			addCriterion("article_post is not null");
			return (Criteria) this;
		}

		public Criteria andArticlePostEqualTo(String value) {
			addCriterion("article_post =", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostNotEqualTo(String value) {
			addCriterion("article_post <>", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostGreaterThan(String value) {
			addCriterion("article_post >", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostGreaterThanOrEqualTo(String value) {
			addCriterion("article_post >=", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostLessThan(String value) {
			addCriterion("article_post <", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostLessThanOrEqualTo(String value) {
			addCriterion("article_post <=", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostLike(String value) {
			addCriterion("article_post like", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostNotLike(String value) {
			addCriterion("article_post not like", value, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostIn(List<String> values) {
			addCriterion("article_post in", values, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostNotIn(List<String> values) {
			addCriterion("article_post not in", values, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostBetween(String value1, String value2) {
			addCriterion("article_post between", value1, value2, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticlePostNotBetween(String value1, String value2) {
			addCriterion("article_post not between", value1, value2, "articlePost");
			return (Criteria) this;
		}

		public Criteria andArticleCommentIsNull() {
			addCriterion("article_comment is null");
			return (Criteria) this;
		}

		public Criteria andArticleCommentIsNotNull() {
			addCriterion("article_comment is not null");
			return (Criteria) this;
		}

		public Criteria andArticleCommentEqualTo(Integer value) {
			addCriterion("article_comment =", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentNotEqualTo(Integer value) {
			addCriterion("article_comment <>", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentGreaterThan(Integer value) {
			addCriterion("article_comment >", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentGreaterThanOrEqualTo(Integer value) {
			addCriterion("article_comment >=", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentLessThan(Integer value) {
			addCriterion("article_comment <", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentLessThanOrEqualTo(Integer value) {
			addCriterion("article_comment <=", value, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentIn(List<Integer> values) {
			addCriterion("article_comment in", values, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentNotIn(List<Integer> values) {
			addCriterion("article_comment not in", values, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentBetween(Integer value1, Integer value2) {
			addCriterion("article_comment between", value1, value2, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleCommentNotBetween(Integer value1, Integer value2) {
			addCriterion("article_comment not between", value1, value2, "articleComment");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeIsNull() {
			addCriterion("article_updatetime is null");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeIsNotNull() {
			addCriterion("article_updatetime is not null");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeEqualTo(Date value) {
			addCriterion("article_updatetime =", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeNotEqualTo(Date value) {
			addCriterion("article_updatetime <>", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeGreaterThan(Date value) {
			addCriterion("article_updatetime >", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("article_updatetime >=", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeLessThan(Date value) {
			addCriterion("article_updatetime <", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeLessThanOrEqualTo(Date value) {
			addCriterion("article_updatetime <=", value, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeIn(List<Date> values) {
			addCriterion("article_updatetime in", values, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeNotIn(List<Date> values) {
			addCriterion("article_updatetime not in", values, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeBetween(Date value1, Date value2) {
			addCriterion("article_updatetime between", value1, value2, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUpdatetimeNotBetween(Date value1, Date value2) {
			addCriterion("article_updatetime not between", value1, value2, "articleUpdatetime");
			return (Criteria) this;
		}

		public Criteria andArticleUrlIsNull() {
			addCriterion("article_url is null");
			return (Criteria) this;
		}

		public Criteria andArticleUrlIsNotNull() {
			addCriterion("article_url is not null");
			return (Criteria) this;
		}

		public Criteria andArticleUrlEqualTo(String value) {
			addCriterion("article_url =", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlNotEqualTo(String value) {
			addCriterion("article_url <>", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlGreaterThan(String value) {
			addCriterion("article_url >", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlGreaterThanOrEqualTo(String value) {
			addCriterion("article_url >=", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlLessThan(String value) {
			addCriterion("article_url <", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlLessThanOrEqualTo(String value) {
			addCriterion("article_url <=", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlLike(String value) {
			addCriterion("article_url like", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlNotLike(String value) {
			addCriterion("article_url not like", value, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlIn(List<String> values) {
			addCriterion("article_url in", values, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlNotIn(List<String> values) {
			addCriterion("article_url not in", values, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlBetween(String value1, String value2) {
			addCriterion("article_url between", value1, value2, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleUrlNotBetween(String value1, String value2) {
			addCriterion("article_url not between", value1, value2, "articleUrl");
			return (Criteria) this;
		}

		public Criteria andArticleViewsIsNull() {
			addCriterion("article_views is null");
			return (Criteria) this;
		}

		public Criteria andArticleViewsIsNotNull() {
			addCriterion("article_views is not null");
			return (Criteria) this;
		}

		public Criteria andArticleViewsEqualTo(Long value) {
			addCriterion("article_views =", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsNotEqualTo(Long value) {
			addCriterion("article_views <>", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsGreaterThan(Long value) {
			addCriterion("article_views >", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsGreaterThanOrEqualTo(Long value) {
			addCriterion("article_views >=", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsLessThan(Long value) {
			addCriterion("article_views <", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsLessThanOrEqualTo(Long value) {
			addCriterion("article_views <=", value, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsIn(List<Long> values) {
			addCriterion("article_views in", values, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsNotIn(List<Long> values) {
			addCriterion("article_views not in", values, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsBetween(Long value1, Long value2) {
			addCriterion("article_views between", value1, value2, "articleViews");
			return (Criteria) this;
		}

		public Criteria andArticleViewsNotBetween(Long value1, Long value2) {
			addCriterion("article_views not between", value1, value2, "articleViews");
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