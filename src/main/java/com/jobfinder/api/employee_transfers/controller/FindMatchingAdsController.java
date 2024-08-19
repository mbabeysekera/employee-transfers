package com.jobfinder.api.employee_transfers.controller;

import com.jobfinder.api.employee_transfers.dto.response.FindMatchingAdsResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.FindMatchingAdsServiceException;
import com.jobfinder.api.employee_transfers.service.FindMatchingAdsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "match")
public class FindMatchingAdsController {

    private final FindMatchingAdsService findMatchingAdsService;

    public FindMatchingAdsController(FindMatchingAdsService findMatchingAdsService) {
        this.findMatchingAdsService = findMatchingAdsService;
    }

    @GetMapping(path = "teachingJobs")
    public ResponseEntity<FindMatchingAdsResponseDto<TeachingJobDetailsDto>> getMatchingJobsForTeachers(
            @RequestParam("userId") int userId) throws FindMatchingAdsServiceException {
        return ResponseEntity.ok(this.findMatchingAdsService.getMatchingJobDetailsAdsForTeachers(userId));
    }
}
