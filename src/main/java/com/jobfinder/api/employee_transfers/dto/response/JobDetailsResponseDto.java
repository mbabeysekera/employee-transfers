package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.constant.enums.EducationQualification;
import com.jobfinder.api.employee_transfers.constant.enums.SeniorityGrade;
import com.jobfinder.api.employee_transfers.dto.common.JobCategoryDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDetailsResponseDto {
    private int userId;
    private SeniorityGrade seniority;
    private int servicePeriod;
    private String currentProvince;
    private String currentDivision;
    private String currentCity;
    private String nextProvince;
    private String nextDivision;
    private String nextCity;
    private String description;
    private EducationQualification educationQualification;
    private String currentEmployer;
    private JobCategoryDetailsDto<?> jobSpecificDetails;
}
