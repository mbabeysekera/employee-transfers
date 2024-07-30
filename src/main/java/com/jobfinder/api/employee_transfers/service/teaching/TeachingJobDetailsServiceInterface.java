package com.jobfinder.api.employee_transfers.service.teaching;

import com.jobfinder.api.employee_transfers.dto.request.TeachingJobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;

public interface TeachingJobDetailsServiceInterface {
    void createJobDetails(TeachingJobDetailsDto jobDetails);
    TeachingJobDetailsDto getJobDetailsForUser(int userId);
    void deleteJobDetailsOfUser(int userId);
}
