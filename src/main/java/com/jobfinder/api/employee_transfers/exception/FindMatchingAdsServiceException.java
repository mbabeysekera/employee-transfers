package com.jobfinder.api.employee_transfers.exception;

import org.springframework.http.HttpStatus;

public class FindMatchingAdsServiceException extends Exception {

    private final HttpStatus status;
    public FindMatchingAdsServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
