package com.jobfinder.api.employee_transfers.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDto {
    private int id;
    private String province;
    private String capitol;
}
