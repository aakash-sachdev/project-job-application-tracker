package com.launchcode.job_application_tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobApplicationHomeController {


    @GetMapping("/")
    public String renderHomePage(Model model){
        model.addAttribute("headingText", "welcome");
        return  "index";
    }

}
