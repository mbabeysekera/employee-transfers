package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "common", name = "divisions")
@AllArgsConstructor
@NoArgsConstructor
public class DivisionModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "division")
    private String division;

    public DivisionModel(String division) {
        this.division = division;
    }
}
