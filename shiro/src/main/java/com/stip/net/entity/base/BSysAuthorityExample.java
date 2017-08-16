package com.stip.net.entity.base;

import com.stip.mybatis.generator.plugin.BaseCriteria;
import com.stip.mybatis.generator.plugin.BaseModelExample;
import java.util.ArrayList;
import java.util.List;

public class BSysAuthorityExample extends BaseModelExample {
    protected List<Criteria> oredCriteria;

    public BSysAuthorityExample() {
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

        public Criteria andAuthNameIsNull() {
            addCriterion("sysAuthority.auth_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNotNull() {
            addCriterion("sysAuthority.auth_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNameEqualTo(String value) {
            addCriterion("sysAuthority.auth_name =", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotEqualTo(String value) {
            addCriterion("sysAuthority.auth_name <>", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThan(String value) {
            addCriterion("sysAuthority.auth_name >", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysAuthority.auth_name >=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThan(String value) {
            addCriterion("sysAuthority.auth_name <", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThanOrEqualTo(String value) {
            addCriterion("sysAuthority.auth_name <=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLike(String value) {
            addCriterion("sysAuthority.auth_name like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotLike(String value) {
            addCriterion("sysAuthority.auth_name not like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIn(List<String> values) {
            addCriterion("sysAuthority.auth_name in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotIn(List<String> values) {
            addCriterion("sysAuthority.auth_name not in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameBetween(String value1, String value2) {
            addCriterion("sysAuthority.auth_name between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotBetween(String value1, String value2) {
            addCriterion("sysAuthority.auth_name not between", value1, value2, "authName");
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