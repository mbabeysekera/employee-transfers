package com.jobfinder.api.employee_transfers.model.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(schema = "common", name = "cities")
@AllArgsConstructor
@NoArgsConstructor
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
