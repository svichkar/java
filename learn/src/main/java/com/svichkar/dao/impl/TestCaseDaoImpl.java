package com.svichkar.dao.impl;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.svichkar.dao.TestCaseDao;
import com.svichkar.model.TestCase;
import org.springframework.stereotype.Repository;

/**
 * Created by svichkar on 6/8/2016.
 */
@Repository
public class TestCaseDaoImpl implements TestCaseDao {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public TestCase findById(Long id) {
        return null;
    }

    @Override
    public void saveOrUpdate(TestCase testCase) {

    }

    @Override
    public void delete(Long id) {

    }
}
