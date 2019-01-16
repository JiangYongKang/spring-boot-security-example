package com.vincent.security.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: vincent
 * Date: 2019-01-16 13:16:00
 * Comment:
 */

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("welcome");
    }

}
