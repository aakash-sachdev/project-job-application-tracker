package com.launchcode.job_application_tracker.data;

import com.launchcode.job_application_tracker.models.JobApplications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationsRepository extends CrudRepository <JobApplications,Integer> {
}
