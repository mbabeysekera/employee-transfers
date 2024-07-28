package com.jobfinder.api.employee_transfers.model.teaching;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(schema = "teaching", name = "teaching_job_details")
@AllArgsConstructor
@NoArgsConstructor
public class TeachingJobDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Column(name = "primary_subject_for_primary_level")
    private String primarySubjectForPLevel;

    @NotNull
    @Column(name = "secondary_subject_for_primary_level")
    private String secondarySubjectForPLevel;

    @NotNull
    @Column(name = "ternary_subject_for_primary_level")
    private String ternarySubjectForPLevel;

    @NotNull
    @Column(name = "primary_subject_for_o_level")
    private String primarySubjectForOLevel;

    @NotNull
    @Column(name = "secondary_subject_for_o_level")
    private String secondarySubjectForOLevel;

    @NotNull
    @Column(name = "ternary_subject_for_o_level")
    private String ternarySubjectForOLevel;

    @NotNull
    @Column(name = "primary_subject_for_a_level")
    private String primarySubjectForALevel;

    @NotNull
    @Column(name = "secondary_subject_for_a_level")
    private String secondarySubjectForALevel;

    @NotNull
    @Column(name = "ternary_subject_for_a_level")
    private String ternarySubjectForALevel;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
