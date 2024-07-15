package com.launchcode.job_application_tracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class JobApplications extends AbstractEntity {

    @ManyToOne
    @NotNull(message = "Position is required.")
    private Position position;

    private String company;

    private String applicationDate;

    private ApplicationStatus applicationStatus;

    private String compensation;

    public JobApplications() {}

    public JobApplications(Position position, String company, ApplicationStatus applicationStatus, String applicationDate, String compensation) {
        this.position = position;
        this.company = company;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
        this.compensation = compensation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return position + " (" + company + ", applied on " + applicationDate + ")";
    }

}
