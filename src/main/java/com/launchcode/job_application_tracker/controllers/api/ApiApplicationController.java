package com.launchcode.job_application_tracker.controllers.api;

import com.launchcode.job_application_tracker.data.JobApplicationsRepository;
import com.launchcode.job_application_tracker.models.JobApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin (origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/applications")
public class ApiApplicationController {

    @Autowired
    private JobApplicationsRepository jobApplicationsRepository;


    @GetMapping
    public ResponseEntity<?> getAllJobApplications() {

        List<JobApplications> jobApplications = (List<JobApplications>) jobApplicationsRepository.findAll();
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobApplicationsId(@PathVariable Integer id) {

        Optional<JobApplications> jobApplicationOptional = jobApplicationsRepository.findById(id);
        if (jobApplicationOptional.isPresent()) {
            return new ResponseEntity<>(jobApplicationOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
