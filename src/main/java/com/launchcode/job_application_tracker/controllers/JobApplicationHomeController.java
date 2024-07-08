package com.launchcode.job_application_tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobApplicationHomeController {


    @GetMapping("/")
    @ResponseBody
    public String renderHomePage(){
        return   "<h2>Launchcode Application Tracker</h2>" +
                "<p>Welcome to the Job Application Tracker," +
                "<br/>View your job applications - <a href='/applications'>Applications</a></p>";
    }

}
