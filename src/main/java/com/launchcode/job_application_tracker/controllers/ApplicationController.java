package com.launchcode.job_application_tracker.controllers;

import com.launchcode.job_application_tracker.data.JobApplicationsRepository;
import com.launchcode.job_application_tracker.data.PositionRepository;
import com.launchcode.job_application_tracker.models.ApplicationStatus;
import com.launchcode.job_application_tracker.models.JobApplications;
import com.launchcode.job_application_tracker.models.Position;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private JobApplicationsRepository jobApplicationsRepository;

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("")
    public String displayApplicationsPage( @RequestParam(required = false) Integer applicationId, Model model) {
        if (applicationId != null) {
            Optional<Position> result = positionRepository.findById(applicationId);
            if (result.isPresent()) {
                Position position = result.get();
                model.addAttribute("positions", position);
                model.addAttribute("jobApplications", position.getJobApplications());
            }
        } else {
            model.addAttribute("jobApplications", jobApplicationsRepository.findAll());
        }
        return "applications/index";
    }

    @GetMapping("/add")
    public String renderAddApplicationForm(Model model) {
        model.addAttribute("jobApplication", new JobApplications());
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("applicationStatus", ApplicationStatus.values());
        return "applications/add";
    }

    @PostMapping("/add")
    public String processAddApplicationForm(@ModelAttribute("jobApplication") @Valid JobApplications jobApplication, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("positions", positionRepository.findAll());
            model.addAttribute("applicationStatus", ApplicationStatus.values());
            return "applications/add";
        }
        jobApplicationsRepository.save(jobApplication);
        return "redirect:/applications";
    }

    @GetMapping("/delete")
    public String renderDeleteApplicationForm(Model model) {
        model.addAttribute("applicationList", jobApplicationsRepository.findAll());
        return "applications/delete";
    }

    @PostMapping("/delete")
    public String processDeleteApplicationForm(@RequestParam(required = false) int[] applicationIds) {
        if (applicationIds != null) {
            for (int id : applicationIds) {
                jobApplicationsRepository.deleteById(id);
            }
        }
        return "redirect:/applications";
    }
}
