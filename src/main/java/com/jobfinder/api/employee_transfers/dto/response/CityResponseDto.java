package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.dto.common.CityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponseDto {
    private List<CityDto> cities;
}
