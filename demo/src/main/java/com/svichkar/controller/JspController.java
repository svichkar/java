package com.svichkar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by konstantin on 3/20/2016.
 */
@Controller
@EnableWebMvc
public class JspController {

    @RequestMapping("/home")
    public String home(ModelAndView modelAndView) {

        return "home";
    }
}
