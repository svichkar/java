package com.svichkar.dao.impl;

import com.svichkar.dao.TestCaseDao;
import com.svichkar.model.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by svichkar on 6/8/2016.
 */
@Component("testCaseDao")
@ComponentScan(basePackages = {"com.svichkar.model"})
public class TestCaseDaoImpl implements TestCaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public java.util.List findAll() {
        return  sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(TestCase.class).getOrderList();
    }

    @Override
    public TestCase findById(Long id) {
        return (TestCase) sessionFactory.getCurrentSession().createQuery("SELECT t FROM testCase as t").uniqueResult();
    }

    @Override
    public void saveOrUpdate(TestCase testCase) {

    }

    @Override
    public void delete(Long id) {

        sessionFactory.getCurrentSession().createQuery("delete from testCase t");
    }
}
