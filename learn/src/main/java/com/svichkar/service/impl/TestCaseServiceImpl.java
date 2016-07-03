package com.svichkar.service.impl;

import com.svichkar.dao.TestCaseDao;
import com.svichkar.model.TestCase;
import com.svichkar.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by konstantin on 6/29/2016.
 */
@Service("testCaseService")
@Transactional
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseDao testCaseDao;

    @Override
    public List findAll() {
        return testCaseDao.findAll();
    }

    @Override
    public TestCase findById(Long id) {
        return testCaseDao.findById(id);
    }

    @Override
    public void saveOrUpdate(TestCase testCase) {
        testCaseDao.saveOrUpdate(testCase);
    }

    @Override
    public void delete(Long id) {
        testCaseDao.delete(id);
    }
}
