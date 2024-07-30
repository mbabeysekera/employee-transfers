package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "common", name = "district")
@AllArgsConstructor
@NoArgsConstructor
public class DistrictModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "district")
    private String district;
}
