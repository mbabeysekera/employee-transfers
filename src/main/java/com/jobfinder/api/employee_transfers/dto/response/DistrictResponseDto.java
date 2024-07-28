package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.dto.common.DistrictDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponseDto {
    private List<DistrictDto> districts;
}
