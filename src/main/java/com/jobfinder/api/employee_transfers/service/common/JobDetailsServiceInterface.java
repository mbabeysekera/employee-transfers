package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.request.JobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.SuccessResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.JobDetailsServiceException;

public interface JobDetailsServiceInterface {
    JobDetailsResponseDto<TeachingJobDetailsDto> getTeachingJobDetails(int userId);

    SuccessResponseDto addJobDetails(JobDetailsRequestDto jobDetails) throws JobDetailsServiceException;

    SuccessResponseDto deleteJobDetails(int userId);
}
