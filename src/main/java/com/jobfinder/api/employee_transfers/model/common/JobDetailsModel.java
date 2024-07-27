package com.jobfinder.api.employee_transfers.model.common;

import com.jobfinder.api.employee_transfers.constant.EducationQualification;
import com.jobfinder.api.employee_transfers.constant.JobCategory;
import com.jobfinder.api.employee_transfers.constant.SeniorityGrade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(schema = "common", name = "job_details")
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Column(name = "seniority")
    @Enumerated(EnumType.STRING)
    private SeniorityGrade seniority;

    @NotNull
    @Column(name = "service_period")
    private int servicePeriod;

    @NotNull
    @Column(name = "current_province")
    private String currentProvince;

    @NotNull
    @Column(name = "current_division")
    private String currentDivision;

    @NotNull
    @Column(name = "current_city")
    private String currentCity;

    @NotNull
    @Column(name = "next_province")
    private String nextProvince;

    @NotNull
    @Column(name = "next_division")
    private String nextDivision;

    @NotNull
    @Column(name = "next_city")
    private String nextCity;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "education_qualification")
    @Enumerated(EnumType.STRING)
    private EducationQualification educationQualification;

    @NotNull
    @Column(name = "current_employer")
    private String currentEmployer;

    @NotNull
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private JobCategory category;
}
