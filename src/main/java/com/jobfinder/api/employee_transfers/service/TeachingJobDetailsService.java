package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.teaching.TeachingJobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.teaching.TeachingJobDetailsServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeachingJobDetailsService implements TeachingJobDetailsServiceInterface {

    private final TeachingJobDetailsRepository teachingJobDetailsRepository;

    public TeachingJobDetailsService(TeachingJobDetailsRepository teachingJobDetailsRepository) {
        this.teachingJobDetailsRepository = teachingJobDetailsRepository;
    }

    @Override
    public void createJobDetails(TeachingJobDetailsDto jobDetails) {
        this.teachingJobDetailsRepository.save(TeachingJobDetailsModel.builder()
                .userId(jobDetails.getUserId())
                .primarySubjectForALevel(jobDetails.getPrimarySubjectForALevel())
                .secondarySubjectForALevel(jobDetails.getSecondarySubjectForALevel())
                .ternarySubjectForALevel(jobDetails.getTernarySubjectForALevel())
                .primarySubjectForOLevel(jobDetails.getPrimarySubjectForOLevel())
                .secondarySubjectForOLevel(jobDetails.getSecondarySubjectForOLevel())
                .ternarySubjectForOLevel(jobDetails.getTernarySubjectForOLevel())
                .primarySubjectForPLevel(jobDetails.getPrimarySubjectForPLevel())
                .secondarySubjectForPLevel(jobDetails.getSecondarySubjectForPLevel())
                .ternarySubjectForPLevel(jobDetails.getTernarySubjectForPLevel())
                .build()
        );
    }

    @Override
    public TeachingJobDetailsDto getJobDetailsForUser(int jobDetailsId) {
        Optional<TeachingJobDetailsModel> teachingJobDetails
                = this.teachingJobDetailsRepository.findByUserId(jobDetailsId);
        if (teachingJobDetails.isEmpty()) {
            return new TeachingJobDetailsDto();
        }
        return TeachingJobDetailsDto.builder()
                .primarySubjectForALevel(teachingJobDetails.get().getPrimarySubjectForALevel())
                .secondarySubjectForALevel(teachingJobDetails.get().getSecondarySubjectForALevel())
                .ternarySubjectForALevel(teachingJobDetails.get().getTernarySubjectForALevel())
                .primarySubjectForOLevel(teachingJobDetails.get().getPrimarySubjectForOLevel())
                .secondarySubjectForOLevel(teachingJobDetails.get().getSecondarySubjectForOLevel())
                .ternarySubjectForOLevel(teachingJobDetails.get().getTernarySubjectForOLevel())
                .primarySubjectForPLevel(teachingJobDetails.get().getPrimarySubjectForPLevel())
                .secondarySubjectForPLevel(teachingJobDetails.get().getSecondarySubjectForPLevel())
                .ternarySubjectForPLevel(teachingJobDetails.get().getTernarySubjectForPLevel())
                .build();
    }

    @Override
    public void deleteJobDetailsOfUser(int jobDetailsId) {
        this.teachingJobDetailsRepository.deleteByUserId(jobDetailsId);
    }
}
