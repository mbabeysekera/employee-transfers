package com.jobfinder.api.employee_transfers.controller;

import com.jobfinder.api.employee_transfers.dto.common.CityDto;
import com.jobfinder.api.employee_transfers.dto.common.DistrictDto;
import com.jobfinder.api.employee_transfers.dto.common.ProvinceDto;
import com.jobfinder.api.employee_transfers.dto.response.GeoLocationResponseDto;
import com.jobfinder.api.employee_transfers.service.CityService;
import com.jobfinder.api.employee_transfers.service.DistrictService;
import com.jobfinder.api.employee_transfers.service.ProvinceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "geoLocation")
public class GeoLocationController {
    private final ProvinceService provinceService;
    private final DistrictService districtService;
    private final CityService cityService;

    public GeoLocationController(ProvinceService provinceService,
                                 DistrictService districtService,
                                 CityService cityService) {
        this.provinceService = provinceService;
        this.districtService = districtService;
        this.cityService = cityService;
    }

    @GetMapping(path = "provinces")
    public ResponseEntity<GeoLocationResponseDto<ProvinceDto>> getProvinces() {
        List<ProvinceDto> provinces = this.provinceService.getProvinces();
        return ResponseEntity.ok(new GeoLocationResponseDto<>("provinces", provinces));
    }

    @GetMapping(path = "districts")
    public ResponseEntity<GeoLocationResponseDto<DistrictDto>> getDistricts() {
        List<DistrictDto> districts = this.districtService.getDistricts();
        return ResponseEntity.ok(new GeoLocationResponseDto<>("districts", districts));
    }

    @GetMapping(path = "cities")
    public ResponseEntity<GeoLocationResponseDto<CityDto>> getCities() {
        List<CityDto> cities = this.cityService.getCities();
        return ResponseEntity.ok(new GeoLocationResponseDto<>("cities", cities));
    }
}
