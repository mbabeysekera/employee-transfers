package com.jobfinder.api.employee_transfers.dto.teaching;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachingJobDetailsDto {
    private String primarySubjectForPLevel;
    private String secondarySubjectForPLevel;
    private String ternarySubjectForPLevel;
    private String primarySubjectForOLevel;
    private String secondarySubjectForOLevel;
    private String ternarySubjectForOLevel;
    private String primarySubjectForALevel;
    private String secondarySubjectForALevel;
    private String ternarySubjectForALevel;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;
}
