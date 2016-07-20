package com.ran.sample.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String greeting(Model model) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-YYYY");
        model.addAttribute("now", sf.format(new Date()));
        return "home";
    }
}