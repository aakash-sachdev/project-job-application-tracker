package com.launchcode.job_application_tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/applications")
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
    public String renderApplicationsHomePage(Model model) {
        List<String> applicationList = new ArrayList<>(applications.values());
        model.addAttribute("applicationList", applicationList);
        return "applications/index";
    }



    @GetMapping("/add")
    public String renderAddApplicationForm() {
        return "applications/add";
    }


    @PostMapping("/add")
    public String processAddApplicationForm(@RequestParam String application){
        applications.put(nextId, application);
        nextId++;
        return "redirect:/applications";
    }

}


