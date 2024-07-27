package com.jobfinder.api.employee_transfers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeachingJobDetailsRequestDto {
    private String primarySubjectForPLevel;
    private String secondarySubjectForPLevel;
    private String ternarySubjectForPLevel;
    private String primarySubjectForOLevel;
    private String secondarySubjectForOLevel;
    private String ternarySubjectForOLevel;
    private String primarySubjectForALevel;
    private String secondarySubjectForALevel;
    private String ternarySubjectForALevel;
    private LocalDateTime createdAt;
}
