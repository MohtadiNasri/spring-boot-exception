package com.springboot.springbootexception.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if (e instanceof java.lang.ArithmeticException) {
            mv.setViewName("mathError");
        }
        if (e instanceof java.lang.NullPointerException) {
            mv.setViewName("nullPointerError");
        }
        mv.addObject("exception", e.toString());
        return mv;
    }
}
