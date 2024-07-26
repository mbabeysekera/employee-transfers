package com.jobfinder.api.employee_transfers.model.teaching;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "teaching", name = "al_subjects")
public class AdvancedLevelSubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    public AdvancedLevelSubjectModel(String subject) {
        this.subject = subject;
    }
}
