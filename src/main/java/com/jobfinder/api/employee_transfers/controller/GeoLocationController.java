package com.jobfinder.api.employee_transfers.controller;

import com.jobfinder.api.employee_transfers.dto.common.CityDto;
import com.jobfinder.api.employee_transfers.dto.common.DistrictDto;
import com.jobfinder.api.employee_transfers.dto.common.ProvinceDto;
import com.jobfinder.api.employee_transfers.dto.response.CityResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.DistrictResponseDto;
import com.jobfinder.api.employee_transfers.dto.response.ProvinceResponseDto;
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
    public ResponseEntity<ProvinceResponseDto> getProvinces() {
        List<ProvinceDto> provinces = this.provinceService.getProvinces();
        return ResponseEntity.ok(new ProvinceResponseDto(provinces));
    }

    @GetMapping(path = "districts")
    public ResponseEntity<DistrictResponseDto> getDistricts() {
        List<DistrictDto> districts = this.districtService.getDistricts();
        return ResponseEntity.ok(new DistrictResponseDto(districts));
    }

    @GetMapping(path = "cities")
    public ResponseEntity<CityResponseDto> getCities() {
        List<CityDto> cities = this.cityService.getCities();
        return ResponseEntity.ok(new CityResponseDto(cities));
    }
}
