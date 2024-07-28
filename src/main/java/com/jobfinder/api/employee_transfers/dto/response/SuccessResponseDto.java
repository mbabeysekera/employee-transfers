package com.jobfinder.api.employee_transfers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponseDto {
    private String name;
    private String description;
    private LocalDateTime timeOfAction;
}
