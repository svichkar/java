package com.svichkar.rest;

import com.svichkar.service.TestCaseService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

/**
 * Created by svichkar on 6/8/2016.
 */
@Controller
@ComponentScan(basePackages = {"com.svichkar.model"})
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        testCaseService.findAll();
        return "index";
    }
}
