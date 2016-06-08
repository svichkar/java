package com.svichkar.dao;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.svichkar.model.TestCase;

/**
 * Created by svichkar on 6/8/2016.
 */
public interface TestCaseDao {

    List findAll();

    TestCase findById(Long id);

    void saveOrUpdate(TestCase testCase);

    void delete(Long id);
}
