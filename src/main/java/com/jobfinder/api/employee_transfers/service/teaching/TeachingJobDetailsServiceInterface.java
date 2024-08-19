package com.jobfinder.api.employee_transfers.service.teaching;

import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;

public interface TeachingJobDetailsServiceInterface {
    TeachingJobDetailsModel createJobDetails(TeachingJobDetailsDto jobDetails);
}
