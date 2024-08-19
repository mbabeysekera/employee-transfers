package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import com.jobfinder.api.employee_transfers.dto.request.JobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.request.TeachingJobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.SuccessResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.JobDetailsServiceException;
import com.jobfinder.api.employee_transfers.map.JobDetailsMapper;
import com.jobfinder.api.employee_transfers.map.TeachingJobDetailsMapper;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.common.JobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.common.JobDetailsServiceInterface;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
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
    public JobDetailsResponseDto<TeachingJobDetailsDto> getTeachingJobDetails(int userId) {
        log.info("Fetch Job Details for userID: {}", userId);
        Optional<JobDetailsModel> jobDetails = this.jobDetailsRepository.findByUserId(userId);
        if (jobDetails.isEmpty()) {
            log.info("Job Details does not exists for userID: {}", userId);
            return new JobDetailsResponseDto<>();
        }
        JobDetailsDto jobDetailsDto = JobDetailsMapper.INSTANCE.jobDetailsEntityToJobDetailsDto(jobDetails.get());
        JobDetailsResponseDto<TeachingJobDetailsDto> response;
        if (Objects.requireNonNull(jobDetails.get().getCategory()) == JobCategory.TEACHER) {
            TeachingJobDetailsModel teachingJobDetailsModel = jobDetails.get().getTeachingJobDetailsModel();
            response = new JobDetailsResponseDto<>(jobDetailsDto, TeachingJobDetailsMapper.INSTANCE.teachingJobDetailsModelToTeachingJobDetailsDto(
                    teachingJobDetailsModel
            ));
        } else {
            response = new JobDetailsResponseDto<>();
        }
        log.info("Fetching Fetch Job Details for userID: {} {}.", userId, ResponseStatusMessages.SUCCESS);
        return response;
    }

    @Transactional
    @Override
    public SuccessResponseDto addJobDetails(JobDetailsRequestDto jobDetails) throws JobDetailsServiceException {
        if (jobDetailsRepository.findByUserId(jobDetails.getUserId()).isPresent()) {
            throw new JobDetailsServiceException("User already have a job detail created", HttpStatus.NOT_ACCEPTABLE);
        }
        log.info("Add Job Details for userID: {}.", jobDetails.getUserId());
        LocalDateTime createdAt = LocalDateTime.now();
        if (jobDetails.getCategory() == JobCategory.TEACHER) {
            jobDetails.getTeachingJobDetails().setCreatedAt(createdAt);
            TeachingJobDetailsModel teachingJobDetailsModel =
                    this.createJobForTeachingTransfer(jobDetails.getTeachingJobDetails());
            this.createJobDetailsWithTeachingJobDetails(jobDetails, teachingJobDetailsModel);
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

    private TeachingJobDetailsModel createJobForTeachingTransfer(
            TeachingJobDetailsRequestDto teachingJobDetails) {
        return this.teachingJobDetailsService.createJobDetails(teachingJobDetails);
    }

    private void createJobDetailsWithTeachingJobDetails(JobDetailsRequestDto jobDetails,
                                                        TeachingJobDetailsModel teachingJobDetailsModel) {
        JobDetailsModel jobDetailsToBeSaved = JobDetailsMapper.INSTANCE.jobDetailsDtoToJobDetailsModel(
                jobDetails
        );
        jobDetailsToBeSaved.setCreatedAt(teachingJobDetailsModel.getCreatedAt());
        jobDetailsToBeSaved.setTeachingJobDetailsModel(teachingJobDetailsModel);
        this.jobDetailsRepository.save(jobDetailsToBeSaved);
    }

    @Override
    public SuccessResponseDto deleteJobDetails(int userId) {
        log.info("Delete Job Details for userID for userID: {}.", userId);
        LocalDateTime timeOfAction = LocalDateTime.now();
        this.jobDetailsRepository.deleteByUserId(userId);
        log.info("Deleting Job Details for userID for userID: {} {}.", userId, ResponseStatusMessages.SUCCESS);
        return new SuccessResponseDto(
                "Job Resource",
                "Job details record deleted for userID: " + userId,
                timeOfAction
        );
    }
}
