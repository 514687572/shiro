package com.stip.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;
import java.util.ArrayList;
import java.util.List;

public class BsysAuthorityExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BsysAuthorityExample() {
        oredCriteria = new ArrayList<Criteria>();
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
        super.clear();
        oredCriteria.clear();
    }

    protected abstract static class GeneratedCriteria extends BaseCriteria {

        public Criteria andAuthIdIsNull() {
            addCriterion("sysAuthority.auth_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthIdIsNotNull() {
            addCriterion("sysAuthority.auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthIdEqualTo(Integer value) {
            addCriterion("sysAuthority.auth_id =", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotEqualTo(Integer value) {
            addCriterion("sysAuthority.auth_id <>", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThan(Integer value) {
            addCriterion("sysAuthority.auth_id >", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysAuthority.auth_id >=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThan(Integer value) {
            addCriterion("sysAuthority.auth_id <", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("sysAuthority.auth_id <=", value, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdIn(List<Integer> values) {
            addCriterion("sysAuthority.auth_id in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotIn(List<Integer> values) {
            addCriterion("sysAuthority.auth_id not in", values, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("sysAuthority.auth_id between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sysAuthority.auth_id not between", value1, value2, "authId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("sysAuthority.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("sysAuthority.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("sysAuthority.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("sysAuthority.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("sysAuthority.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysAuthority.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("sysAuthority.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sysAuthority.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("sysAuthority.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("sysAuthority.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sysAuthority.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sysAuthority.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andElementListIsNull() {
            addCriterion("sysAuthority.element_list is null");
            return (Criteria) this;
        }

        public Criteria andElementListIsNotNull() {
            addCriterion("sysAuthority.element_list is not null");
            return (Criteria) this;
        }

        public Criteria andElementListEqualTo(String value) {
            addCriterion("sysAuthority.element_list =", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListNotEqualTo(String value) {
            addCriterion("sysAuthority.element_list <>", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListGreaterThan(String value) {
            addCriterion("sysAuthority.element_list >", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListGreaterThanOrEqualTo(String value) {
            addCriterion("sysAuthority.element_list >=", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListLessThan(String value) {
            addCriterion("sysAuthority.element_list <", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListLessThanOrEqualTo(String value) {
            addCriterion("sysAuthority.element_list <=", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListLike(String value) {
            addCriterion("sysAuthority.element_list like", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListNotLike(String value) {
            addCriterion("sysAuthority.element_list not like", value, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListIn(List<String> values) {
            addCriterion("sysAuthority.element_list in", values, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListNotIn(List<String> values) {
            addCriterion("sysAuthority.element_list not in", values, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListBetween(String value1, String value2) {
            addCriterion("sysAuthority.element_list between", value1, value2, "elementList");
            return (Criteria) this;
        }

        public Criteria andElementListNotBetween(String value1, String value2) {
            addCriterion("sysAuthority.element_list not between", value1, value2, "elementList");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("sysAuthority.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("sysAuthority.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("sysAuthority.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("sysAuthority.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("sysAuthority.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sysAuthority.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("sysAuthority.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("sysAuthority.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("sysAuthority.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("sysAuthority.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("sysAuthority.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("sysAuthority.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("sysAuthority.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("sysAuthority.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}