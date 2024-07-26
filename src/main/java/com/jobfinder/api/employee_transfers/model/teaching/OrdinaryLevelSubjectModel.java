package com.jobfinder.api.employee_transfers.model.teaching;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "teaching", name = "ol_subjects")
public class OrdinaryLevelSubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    public OrdinaryLevelSubjectModel(String subject) {
        this.subject = subject;
    }
}
