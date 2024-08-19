package com.jobfinder.api.employee_transfers.controller;

import com.jobfinder.api.employee_transfers.dto.request.JobDetailsRequestDto;
import com.jobfinder.api.employee_transfers.dto.response.JobDetailsResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.SuccessResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.exception.JobDetailsServiceException;
import com.jobfinder.api.employee_transfers.service.JobDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "job")
@RestController
public class JobController {

    private final JobDetailsService jobDetailsService;

    public JobController(JobDetailsService jobDetailsService) {
        this.jobDetailsService = jobDetailsService;
    }

    @PostMapping(path = "create")
    public ResponseEntity<SuccessResponseDto> addJobDetails(@RequestBody JobDetailsRequestDto jobDetails)
            throws JobDetailsServiceException {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.jobDetailsService.addJobDetails(jobDetails));
    }

    @GetMapping(path = "getTeacherDetails/{userId}")
    public ResponseEntity<JobDetailsResponseDto<TeachingJobDetailsDto>>
    getJobDetailsForUser(@PathVariable(name = "userId") int userId) {
        return ResponseEntity.ok(this.jobDetailsService.getTeachingJobDetails(userId));
    }
}
