package com.jobfinder.api.employee_transfers.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private int id;
    private String city;
    private Float latitude;
    private Float longitude;
}
