package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.common.JobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.common.JobDetailsServiceInterface;
import com.jobfinder.api.employee_transfers.service.teaching.TeachingJobDetailsServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobDetailsService implements JobDetailsServiceInterface {

    private final JobDetailsRepository jobDetailsRepository;
    private final TeachingJobDetailsServiceInterface teachingJobDetailsService;

    public JobDetailsService(JobDetailsRepository jobDetailsRepository,
                             TeachingJobDetailsServiceInterface teachingJobDetailsService) {
        this.jobDetailsRepository = jobDetailsRepository;
        this.teachingJobDetailsService = teachingJobDetailsService;
    }

    @Override
    public JobDetailsDto getJobDetails(int userId) {
        Optional<JobDetailsModel> jobDetails = this.jobDetailsRepository.findByUserId(userId);
        if (jobDetails.isEmpty()) {
            return new JobDetailsDto();
        }
        TeachingJobDetailsDto teachingJobDetails = this.teachingJobDetailsService.getJobDetailsForUser(
                userId
        );
        return JobDetailsDto.builder()
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
    public void addJobDetails(JobDetailsDto jobDetails) {
        JobDetailsModel jobDetailsToBeSaved = JobDetailsModel.builder()
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
                .currentCity(jobDetails.getCurrentCity()).build();
        this.jobDetailsRepository.save(
                jobDetailsToBeSaved
        );
        this.teachingJobDetailsService.createJobDetails(TeachingJobDetailsDto.builder()
                .userId(jobDetailsToBeSaved.getUserId())
                .primarySubjectForALevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForALevel())
                .secondarySubjectForALevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForALevel())
                .ternarySubjectForALevel(jobDetails.getTeachingJobDetails().getTernarySubjectForALevel())
                .primarySubjectForOLevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForOLevel())
                .secondarySubjectForOLevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForOLevel())
                .ternarySubjectForOLevel(jobDetails.getTeachingJobDetails().getTernarySubjectForOLevel())
                .primarySubjectForPLevel(jobDetails.getTeachingJobDetails().getPrimarySubjectForPLevel())
                .secondarySubjectForPLevel(jobDetails.getTeachingJobDetails().getSecondarySubjectForPLevel())
                .ternarySubjectForPLevel(jobDetails.getTeachingJobDetails().getTernarySubjectForPLevel())
                .build());
    }

    @Override
    public void deleteJobDetails(int userId) {
        this.jobDetailsRepository.deleteByUserId(userId);
    }
}
