package com.jobfinder.api.employee_transfers.service.teaching;

import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;

public interface TeachingJobDetailsServiceInterface {
    void createJobDetails(TeachingJobDetailsDto jobDetails);
    TeachingJobDetailsDto getJobDetailsForUser(int jobDetailsId);
    void deleteJobDetailsOfUser(int jobDetailsId);
}
