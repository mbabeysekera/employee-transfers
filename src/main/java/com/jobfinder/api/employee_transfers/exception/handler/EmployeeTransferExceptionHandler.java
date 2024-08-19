package com.jobfinder.api.employee_transfers.exception.handler;


import com.jobfinder.api.employee_transfers.dto.response.ErrorResponseDto;
import com.jobfinder.api.employee_transfers.exception.FindMatchingAdsServiceException;
import com.jobfinder.api.employee_transfers.exception.JobDetailsServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class EmployeeTransferExceptionHandler {
    @ExceptionHandler(value = {
            FindMatchingAdsServiceException.class
    })
    public ResponseEntity<ErrorResponseDto> findMatchingServiceException(
            FindMatchingAdsServiceException exception) {
        return ResponseEntity.status(exception.getStatus()).body(
                new ErrorResponseDto(
                        "Find Matching Ads Service Exception.",
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(value = {
            JobDetailsServiceException.class
    })
    public ResponseEntity<ErrorResponseDto> jobDetailsServiceException(
            JobDetailsServiceException exception) {
        return ResponseEntity.status(exception.getStatus()).body(
                new ErrorResponseDto(
                        "Job Details Service Exception",
                        exception.getMessage(),
                        LocalDateTime.now()
                )
        );
    }
}
