package com.svichkar.dao;

import com.svichkar.model.TestCase;

import java.util.List;

/**
 * Created by svichkar on 6/8/2016.
 */
public interface TestCaseDao {

    List findAll();

    TestCase findById(Long id);

    void saveOrUpdate(TestCase testCase);

    void delete(Long id);
}
