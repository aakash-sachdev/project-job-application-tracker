package com.launchcode.job_application_tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/applications")
@ResponseBody
public class ApplicationController {

    private static int nextId = 6;

    private static final Map<Integer, String> applications = new HashMap<>() {{
        put(1, "Microsoft CEO");
        put(2, "Apple Hardware Design Head");
        put(3, "Open A.I LLM architect");
        put(4, "Google optimization engineer");
        put(5, "Netflix content head");
    }};

    @GetMapping("")
    public String renderApplicationsHomePage() {
        StringBuilder applicationsList = new StringBuilder();
        for (int applicationsId : applications.keySet()) {
            String application = applications.get(applicationsId);
            applicationsList.append("<li><a href='/applications/details/").append(applicationsId).append("'>").append(application).append("</a></li>");
        }

        return "<html>" +
                "<body>" +
                "<h2>Applications</h2>" +
                "<ul>" +
                applicationsList+
                "</ul>"+
                "<p>Click <a href='/applications/add'>here</a> to add another application.</p>" +
                "</body>" +
                "</html>";
    }


    @GetMapping("/add")
    public String renderAddApplicationForm() {
        return "<html>" +
                "<body>" +
                "<form action='/applications/add' method='POST'>" +
                "<p>Enter the name of an application:</p>" +
                "<input type='text' name='application' />" +
                "<button type='submit'>Submit</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/add")
    public String addApplication(@RequestParam String application){
        applications.put(nextId, application);
        nextId++;
        return "<html>" +
                "<body>" +
                "<h3>APPLICATION ADDED</h3>" +
                "<p>You have successfully added " + application + " to the collection.</p>" +
                "<p><a href='/applications/add'>Add another application</a> or <a href='/applications'>view the updated list</a> of applications.</p>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("/details/{applicationId}")
    public String displayApplicationDetails(@PathVariable int applicationId){
        return "<html>" +
                "<body>" +
                "<h3>Application</h3>" +
                "<p><b>ID:</b> " + applicationId + "</p>" +
                "<p><b>Name:</b> " + applications.get(applicationId) + "</p>" +
                "</body>" +
                "</html>";
    }
}
