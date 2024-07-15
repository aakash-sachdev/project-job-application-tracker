package com.launchcode.job_application_tracker.models;

public enum ApplicationStatus {

    APPLIED("Applied"),
    INTERVIEWING(" Interviewing"),
    OFFER("Offer"),
    REJECTED("Rejected"),
    WITHDRAWN("Withdrawn");


    private final String displayName;

    ApplicationStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
