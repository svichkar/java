package com.nixsolutions.studentgrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by konstantin on 2/1/2016.
 */
@Controller
@RequestMapping("/angular")
public class AngularController {

    @RequestMapping(method = RequestMethod.GET)
    public String startAngular(Model model) {
        return "angular";
    }
}
