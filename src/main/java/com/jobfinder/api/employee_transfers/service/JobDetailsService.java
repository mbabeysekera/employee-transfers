package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import com.jobfinder.api.employee_transfers.dto.request.JobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.request.TeachingJobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.SuccessResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.common.JobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.common.JobDetailsServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
public class JobDetailsService implements JobDetailsServiceInterface {

    private final JobDetailsRepository jobDetailsRepository;
    private final TeachingJobDetailsService teachingJobDetailsService;

    public JobDetailsService(JobDetailsRepository jobDetailsRepository,
                             TeachingJobDetailsService teachingJobDetailsService) {
        this.jobDetailsRepository = jobDetailsRepository;
        this.teachingJobDetailsService = teachingJobDetailsService;
    }

    @Override
    public JobDetailsResponseDto getJobDetails(int userId) {
        log.info("Fetch Job Details for userID: {}", userId);
        Optional<JobDetailsModel> jobDetails = this.jobDetailsRepository.findByUserId(userId);
        if (jobDetails.isEmpty()) {
            log.info("Job Details does not exists for userID: {}", userId);
            return new JobDetailsResponseDto();
        }
        TeachingJobDetailsRequestDto teachingJobDetails = this.teachingJobDetailsService.getJobDetailsForUser(
                userId
        );
        log.info("Fetching Fetch Job Details for userID: {} {}.", userId,  ResponseStatusMessages.SUCCESS);
        return JobDetailsResponseDto.builder()
                .userId(jobDetails.get().getUserId())
                .seniority(jobDetails.get().getSeniority())
                .servicePeriod(jobDetails.get().getServicePeriod())
                .currentProvince(jobDetails.get().getCurrentProvince())
                .currentDivision(jobDetails.get().getCurrentDivision())
                .currentCity(jobDetails.get().getCurrentCity())
                .nextCity(jobDetails.get().getNextCity())
                .nextDivision(jobDetails.get().getNextDivision())
                .nextProvince(jobDetails.get().getNextProvince())
                .description(jobDetails.get().getDescription())
                .educationQualification(jobDetails.get().getEducationQualification())
                .currentEmployer(jobDetails.get().getCurrentEmployer())
                .category(jobDetails.get().getCategory())
                .currentCity(jobDetails.get().getCurrentCity())
                .teachingJobDetails(teachingJobDetails).build();
    }

    @Override
    public SuccessResponseDto addJobDetails(JobDetailsRequestDto jobDetails) {
        log.info("Add Job Details for userID: {}.", jobDetails.getUserId());
        LocalDateTime createdAt = LocalDateTime.now();
        JobDetailsModel jobDetailsToBeSaved = JobDetailsModel.builder()
                .userId(jobDetails.getUserId())
                .seniority(jobDetails.getSeniority())
                .servicePeriod(jobDetails.getServicePeriod())
                .currentProvince(jobDetails.getCurrentProvince())
                .currentDivision(jobDetails.getCurrentDivision())
                .currentCity(jobDetails.getCurrentCity())
                .nextCity(jobDetails.getNextCity())
                .nextDivision(jobDetails.getNextDivision())
                .nextProvince(jobDetails.getNextProvince())
                .description(jobDetails.getDescription())
                .educationQualification(jobDetails.getEducationQualification())
                .currentEmployer(jobDetails.getCurrentEmployer())
                .category(jobDetails.getCategory())
                .currentCity(jobDetails.getCurrentCity()).createdAt(createdAt)
                .build();
        this.jobDetailsRepository.save(
                jobDetailsToBeSaved
        );
        if (jobDetails.getCategory() == JobCategory.TEACHER) {
            this.teachingJobDetailsService.createJobDetails(TeachingJobDetailsDto.builder()
                    .userId(jobDetails.getUserId())
                    .primarySubjectForALevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForALevel())
                    .secondarySubjectForALevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForALevel())
                    .ternarySubjectForALevel(jobDetails.getTeachingJobDetails().getTernarySubjectForALevel())
                    .primarySubjectForOLevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForOLevel())
                    .secondarySubjectForOLevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForOLevel())
                    .ternarySubjectForOLevel(jobDetails.getTeachingJobDetails().getTernarySubjectForOLevel())
                    .primarySubjectForPLevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForPLevel())
                    .secondarySubjectForPLevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForPLevel())
                    .ternarySubjectForPLevel(jobDetails.getTeachingJobDetails().getTernarySubjectForPLevel())
                    .createdAt(createdAt)
                    .build());
        }
        log.info("Adding Job Details for userID: {} {}.",
                jobDetails.getUserId(),
                ResponseStatusMessages.SUCCESS);
        return new SuccessResponseDto(
                "Job Resource",
                "Job details record created for: " + jobDetails.getCategory(),
                createdAt
        );
    }

    @Override
    public SuccessResponseDto deleteJobDetails(int userId) {
        log.info("Delete Job Details for userID for userID: {}.", userId);
        LocalDateTime timeOfAction = LocalDateTime.now();
        this.jobDetailsRepository.deleteByUserId(userId);
        log.info("Deleting Job Details for userID for userID: {} {}.", userId,  ResponseStatusMessages.SUCCESS);
        return new SuccessResponseDto(
                "Job Resource",
                "Job details record deleted for userID: " + userId,
                timeOfAction
        );
    }
}
