package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.response.FindMatchingAdsResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.FindMatchingAdsServiceException;

public interface FindMatchingAdsServiceInterface {
    FindMatchingAdsResponseDto<TeachingJobDetailsDto>
    getMatchingJobDetailsAdsForTeachers(int userId) throws FindMatchingAdsServiceException;
}
