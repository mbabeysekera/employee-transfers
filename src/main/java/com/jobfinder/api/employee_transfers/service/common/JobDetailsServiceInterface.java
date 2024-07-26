package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;

public interface JobDetailsServiceInterface {
    JobDetailsDto getJobDetails(int userId);
    void addJobDetails(JobDetailsDto jobDetails);

    void deleteJobDetails(int userId);
}
