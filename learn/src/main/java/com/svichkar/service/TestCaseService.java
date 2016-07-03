package com.svichkar.service;

import com.svichkar.model.TestCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by konstantin on 6/29/2016.
 */
public interface TestCaseService {

    List findAll();

    TestCase findById(Long id);

    void saveOrUpdate(TestCase testCase);

    void delete(Long id);
}
