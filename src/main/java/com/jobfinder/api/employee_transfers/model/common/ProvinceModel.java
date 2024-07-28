package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(schema = "common", name = "provinces")
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "province")
    private String province;

    @Column(name = "capitol")
    private String capitol;

    public ProvinceModel(String province) {
        this.province = province;
    }
}
