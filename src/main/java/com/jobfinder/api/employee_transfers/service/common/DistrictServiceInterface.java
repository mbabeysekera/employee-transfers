package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.common.DistrictDto;

import java.util.List;

public interface DistrictServiceInterface {
    String getDistrict(int districtId);
    List<DistrictDto> getDistricts();
}
