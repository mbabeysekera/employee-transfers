package com.jobfinder.api.employee_transfers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocationResponseDto<T> {
    private String description;
    private List<T> items;
}
