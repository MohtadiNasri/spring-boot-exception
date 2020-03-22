package com.springboot.springbootexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
