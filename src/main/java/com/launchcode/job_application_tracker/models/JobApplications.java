package com.launchcode.job_application_tracker.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class JobApplications {

    public static int nextId = 1;

    private final int id;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @Size(min = 2, max =30, message = "Company's name must be 2-30 characters long.")
    private String company;

    public JobApplications() {
        this.id=nextId;
        nextId++;
    }

    public JobApplications(String jobTitle, String company) {
        this();
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        JobApplications.nextId = nextId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return jobTitle + "(" + company + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobApplications that = (JobApplications) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
