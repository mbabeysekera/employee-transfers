package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.map.TeachingJobDetailsMapper;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import com.jobfinder.api.employee_transfers.repository.teaching.TeachingJobDetailsRepository;
import com.jobfinder.api.employee_transfers.service.teaching.TeachingJobDetailsServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TeachingJobDetailsService implements TeachingJobDetailsServiceInterface {

    private final TeachingJobDetailsRepository teachingJobDetailsRepository;

    public TeachingJobDetailsService(TeachingJobDetailsRepository teachingJobDetailsRepository) {
        this.teachingJobDetailsRepository = teachingJobDetailsRepository;
    }

    @Override
    public TeachingJobDetailsModel createJobDetails(TeachingJobDetailsDto jobDetails) {
        log.info("Add Teaching Job Details.");
        TeachingJobDetailsModel jobDetailsModel =
                TeachingJobDetailsMapper.INSTANCE.teachingJobDetailsDtoToTeachingJobDetailsModel(
                        jobDetails
                );
        TeachingJobDetailsModel teachingJobDetailsModel = this.teachingJobDetailsRepository
                .save(jobDetailsModel);
        log.info("Adding Teaching Job Details: {}",
                ResponseStatusMessages.SUCCESS);
        return teachingJobDetailsModel;
    }
}
