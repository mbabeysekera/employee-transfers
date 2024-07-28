package com.jobfinder.api.employee_transfers.service.common;

import com.jobfinder.api.employee_transfers.dto.common.CityDto;

import java.util.List;

public interface CityServiceInterface {
    String getCity(int cityId);
    List<CityDto> getCities();
}
