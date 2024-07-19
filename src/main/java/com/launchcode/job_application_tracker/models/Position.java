package com.launchcode.job_application_tracker.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Position extends AbstractEntity{

    private String appliedPosition;

    private String location;
    private String company;
    private String notes;

    @OneToMany(mappedBy="position")
    @JsonBackReference
    private final List<JobApplications> jobApplications  = new ArrayList<>();

    public Position() {}

    public Position(String appliedPosition, String location, String company, String notes) {
        this.appliedPosition = appliedPosition;
        this.location = location;
        this.company = company;
        this.notes = notes;
    }

    public String getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(String appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<JobApplications> getJobApplications() {
        return jobApplications;
    }

    @Override
    public String toString() {
        return appliedPosition;
    }
}
