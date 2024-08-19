package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import com.jobfinder.api.employee_transfers.dto.common.MatchingCriteriaDto;
import com.jobfinder.api.employee_transfers.dto.response.FindMatchingAdsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.FindMatchingAdsServiceException;
import com.jobfinder.api.employee_transfers.map.JobDetailsMapper;
import com.jobfinder.api.employee_transfers.map.TeachingJobDetailsMapper;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.common.JobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.common.FindMatchingAdsServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class FindMatchingAdsService implements FindMatchingAdsServiceInterface {

    private final JobDetailsRepository jobDetailsRepository;

    public FindMatchingAdsService(JobDetailsRepository jobDetailsRepository) {
        this.jobDetailsRepository = jobDetailsRepository;
    }

    @Override
    public FindMatchingAdsResponseDto<TeachingJobDetailsDto> getMatchingJobDetailsAdsForTeachers(int userId)
            throws FindMatchingAdsServiceException {
        Optional<JobDetailsModel> finderJobDetails = this.jobDetailsRepository.findByUserId(userId);
        if (finderJobDetails.isEmpty()) {
            throw new FindMatchingAdsServiceException("User not found for user ID: " + userId, HttpStatus.NOT_FOUND);
        }
        List<JobDetailsResponseDto<TeachingJobDetailsDto>> allJobsMatched;
        if (finderJobDetails.get().getCategory() == JobCategory.TEACHER) {
            allJobsMatched = getAllJobAdsForTeachingMatchesFinder(new MatchingCriteriaDto(
                    finderJobDetails.get().getNextProvince(),
                    finderJobDetails.get().getNextDivision(),
                    finderJobDetails.get().getNextCity()
            ));
        } else {
            allJobsMatched = new ArrayList<>();
        }
        return new FindMatchingAdsResponseDto<>("Matching Job details", allJobsMatched);
    }

    private List<JobDetailsResponseDto<TeachingJobDetailsDto>> getAllJobAdsForTeachingMatchesFinder(
            MatchingCriteriaDto matchingCriteria
    ) {
        List<JobDetailsModel> jobDetailsModels =
                this.jobDetailsRepository.findJobDetailsByMatchingCriteria(matchingCriteria);
        return jobDetailsModels.stream().map(jobDetailsModel ->
                new JobDetailsResponseDto<>(
                        JobDetailsMapper.INSTANCE
                                .jobDetailsEntityToJobDetailsDto(jobDetailsModel),
                        TeachingJobDetailsMapper.INSTANCE
                                .teachingJobDetailsModelToTeachingJobDetailsDto(
                                        jobDetailsModel.getTeachingJobDetailsModel()
                                )
                )
        ).toList();
    }
}
