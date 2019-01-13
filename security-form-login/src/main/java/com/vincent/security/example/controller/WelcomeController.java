package com.vincent.security.example.controller;

import com.vincent.security.example.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: vincent
 * Date: 2019-01-13 14:41:00
 * Comment:
 */

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends BaseController {

    @GetMapping
    public ModelAndView welcome() {
        return super.modelAndView("welcome", "message", "登录成功");
    }

}
