package com.launchcode.job_application_tracker.data;

import com.launchcode.job_application_tracker.models.JobApplications;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JobApplicationData {

    private static final Map<Integer, JobApplications> jobApplications = new HashMap<>();

    public static void add(JobApplications application){
        jobApplications.put(application.getId(), application);
    }

    public static JobApplications findById(int id){
        return jobApplications.get(id);
    }

    public static Collection<JobApplications> getAll(){
        return jobApplications.values();
    }

    public static void remove(int id) {
        jobApplications.remove(id);
    }

}
