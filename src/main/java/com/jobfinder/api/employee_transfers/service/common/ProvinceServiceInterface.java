package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.common.ProvinceDto;

import java.util.List;

public interface ProvinceServiceInterface {
    String getProvince(int provinceId);

    List<ProvinceDto> getProvinces();
}
