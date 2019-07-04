package com.lijm.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
//public class ControllerErerr {
//    private static final String DEFAULT_ERROR_VIEW = "error";
//
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultError(HttpServletRequest request, Exception e){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("exception", e);
//        mv.addObject("url", request.getRequestURI());
//        mv.setViewName(DEFAULT_ERROR_VIEW);
//        return mv;
//    }
//}
