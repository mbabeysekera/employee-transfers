package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "common", name = "provinces")
public class ProvinceModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "province")
    private String province;

    public ProvinceModel(String province) {
        this.province = province;
    }
}
