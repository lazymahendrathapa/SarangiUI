package com.sarangiUI.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        return "index";

    }

}
