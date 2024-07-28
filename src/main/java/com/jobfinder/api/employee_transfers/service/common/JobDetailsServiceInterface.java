package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.request.JobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.SuccessResponseDto;

public interface JobDetailsServiceInterface {
    JobDetailsResponseDto getJobDetails(int userId);
    SuccessResponseDto addJobDetails(JobDetailsRequestDto jobDetails);

    SuccessResponseDto deleteJobDetails(int userId);
}
