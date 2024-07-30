package com.jobfinder.api.employee_transfers.controller;

import com.jobfinder.api.employee_transfers.dto.common.JobCategoryListDto;
import com.jobfinder.api.employee_transfers.dto.response.MetadataResponseDto;
import com.jobfinder.api.employee_transfers.service.MetadataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "metadata")
public class MetadataController {
    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping(path = "jobCategory")
    public ResponseEntity<MetadataResponseDto<JobCategoryListDto>> getJobCategories() {
        MetadataResponseDto<JobCategoryListDto> jobCategoryList = new MetadataResponseDto<>(
                "jobCategory",
                this.metadataService.getJobCategories());
        return ResponseEntity.ok(jobCategoryList);
    }
}
