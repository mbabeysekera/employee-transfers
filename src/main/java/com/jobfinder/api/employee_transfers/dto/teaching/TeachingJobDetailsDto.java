package com.jobfinder.api.employee_transfers.dto.teaching;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeachingJobDetailsDto {
    @JsonIgnore
    private int userId;
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
