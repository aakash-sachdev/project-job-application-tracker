package com.launchcode.job_application_tracker.controllers;

import com.launchcode.job_application_tracker.data.JobApplicationData;
import com.launchcode.job_application_tracker.models.JobApplications;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applications")
public class ApplicationController {


    @GetMapping("")
    public String renderApplicationsHomePage(Model model) {
        model.addAttribute("applicationList", JobApplicationData.getAll());
        return "applications/index";
    }


    @GetMapping("/add")
    public String renderAddApplicationForm(Model model) {
        model.addAttribute("jobApplication",new JobApplications());
        return "applications/add";
    }


    @PostMapping("/add")
    public String processAddApplicationForm(@ModelAttribute("jobApplication") @Valid JobApplications jobApplication, Errors errors){
        if(errors.hasErrors()){
            return "applications/add";
        }else{
        JobApplicationData.add(jobApplication);
        return "redirect:/applications";
        }
    }

    @GetMapping("/delete")
    public String renderDeleteApplicationForm(Model model){
        model.addAttribute("applicationList", JobApplicationData.getAll());
        return "applications/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] applicationIds) {
        if (applicationIds != null) {
            for (int id : applicationIds) {
                JobApplicationData.remove(id);
            }
        }
        return "redirect:/applications";
    }


}


