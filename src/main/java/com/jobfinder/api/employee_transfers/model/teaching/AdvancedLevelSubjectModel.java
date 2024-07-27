package com.jobfinder.api.employee_transfers.model.teaching;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "teaching", name = "al_subjects")
@AllArgsConstructor
@NoArgsConstructor
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
