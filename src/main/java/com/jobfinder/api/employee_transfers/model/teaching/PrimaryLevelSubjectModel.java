package com.jobfinder.api.employee_transfers.model.teaching;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "teaching", name = "pr_subjects")
public class PrimaryLevelSubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    public PrimaryLevelSubjectModel(String subject) {
        this.subject = subject;
    }
}
