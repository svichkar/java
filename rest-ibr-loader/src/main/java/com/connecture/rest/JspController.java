package com.connecture.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class JspController
{
  @RequestMapping("/")
  public String home(ModelAndView modelAndView) {

    return "index";
  }
}
