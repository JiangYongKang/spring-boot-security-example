package com.vincent.security.example.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: vincent
 * Date: 2019-01-13 14:43:00
 * Comment:
 */

public class BaseController {

    public ResponseEntity<?> success(Object data) {
        return ResponseEntity.ok(new RestResponse(data));
    }

    public ModelAndView modelAndView(String viewName, String attributeName, Object attributeValue) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(attributeName, attributeValue);
        return modelAndView;
    }

}
