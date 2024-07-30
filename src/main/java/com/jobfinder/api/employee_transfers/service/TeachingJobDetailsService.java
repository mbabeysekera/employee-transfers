package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.teaching.TeachingJobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.teaching.TeachingJobDetailsServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class TeachingJobDetailsService implements TeachingJobDetailsServiceInterface {

    private final TeachingJobDetailsRepository teachingJobDetailsRepository;

    public TeachingJobDetailsService(TeachingJobDetailsRepository teachingJobDetailsRepository) {
        this.teachingJobDetailsRepository = teachingJobDetailsRepository;
    }

    @Override
    public void createJobDetails(TeachingJobDetailsDto jobDetails) {
        log.info("Add Teaching Job Details for userID: {}.", jobDetails.getUserId());
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
                .createdAt(jobDetails.getCreatedAt())
                .build()
        );
        log.info("Adding Teaching Job Details for userID: {} {}.",
                jobDetails.getUserId(),
                ResponseStatusMessages.SUCCESS);
    }

    @Override
    public TeachingJobDetailsDto getJobDetailsForUser(int userId) {
        log.info("Fetch Teaching Job Details for userID: {}", userId);
        Optional<TeachingJobDetailsModel> teachingJobDetails
                = this.teachingJobDetailsRepository.findByUserId(userId);
        if (teachingJobDetails.isEmpty()) {
            log.info("Teaching Job Details does not exists for userID: {}", userId);
            return new TeachingJobDetailsDto();
        }
        log.info("Fetching Teaching Job Details for userID: {} {}.", userId,  ResponseStatusMessages.SUCCESS);
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
                .createdAt(teachingJobDetails.get().getCreatedAt())
                .build();
    }

    @Override
    public void deleteJobDetailsOfUser(int userId) {
        log.info("Delete Job Details for userID for userID: {}.", userId);
        this.teachingJobDetailsRepository.deleteByUserId(userId);
        log.info("Deleting Job Details for userID: {} {}.", userId,  ResponseStatusMessages.SUCCESS);
    }
}
