package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.dto.common.ProvinceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceResponseDto {
    private List<ProvinceDto> provinces;
}
