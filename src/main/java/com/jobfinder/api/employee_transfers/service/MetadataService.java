package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import com.jobfinder.api.employee_transfers.dto.common.JobCategoryListDto;
import com.jobfinder.api.employee_transfers.service.common.MetadataServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Log4j2
@Service
public class MetadataService implements MetadataServiceInterface {
    @Override
    public JobCategoryListDto getJobCategories() {
        JobCategory[] jobCategories = JobCategory.values();
        return new JobCategoryListDto(Arrays.stream(jobCategories).toList());
    }
}
