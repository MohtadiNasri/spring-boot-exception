package com.springboot.springbootexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/add")
    public String add() {
        //Dividing by 0 will raise an exception
        /*There was an unexpected error (type=Internal Server Error, status=500).
                / by zero
        java.lang.ArithmeticException: / by zero*/
        int num = 10 / 0;
        return "add";
    }

    @ExceptionHandler(value={java.lang.ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.toString());
        modelAndView.setViewName("mathError");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update() {
        String name = null;
        //The line below will raise an error as the name is null
        name = name.toLowerCase(); // this should cause null pointer exception
        return "update";
    }

    @ExceptionHandler(value={java.lang.NullPointerException.class})
    public ModelAndView handleNullPointerException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e.toString());
        modelAndView.setViewName("nullPointerError");
        return modelAndView;
    }

}
