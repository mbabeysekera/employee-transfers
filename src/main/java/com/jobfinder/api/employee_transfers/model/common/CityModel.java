package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "common", name = "cities")
public class CityModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String city;

    public CityModel(String city) {
        this.city = city;
    }
}
