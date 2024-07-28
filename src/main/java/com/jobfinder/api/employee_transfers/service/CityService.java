package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.common.CityDto;
import com.jobfinder.api.employee_transfers.model.common.CityModel;
import com.jobfinder.api.employee_transfers.repository.common.CityRepository;
import com.jobfinder.api.employee_transfers.service.common.CityServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CityService implements CityServiceInterface {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public String getCity(int cityId) {
        log.info("Fetch city for ID: {}", cityId);
        Optional<CityModel> city = this.cityRepository.findById(cityId);
        if (city.isEmpty()) {
            log.info("City does not exists for ID: {}", cityId);
            return "";
        }
        log.info("Fetching city for ID: {} {}.", cityId,  ResponseStatusMessages.SUCCESS);
        return city.get().getCity();
    }

    @Override
    public List<CityDto> getCities() {
        log.info("Prepare cities");
        List<CityModel> cities = this.cityRepository.findAll();
        if (cities.isEmpty()) {
            log.info("Cities not exists in the system");
            return new ArrayList<>();
        }
        log.info("Fetching Cities: {}", ResponseStatusMessages.SUCCESS);
        return cities.stream().map(cityModel -> new CityDto(
                cityModel.getId(),
                cityModel.getCity(),
                cityModel.getLatitude(),
                cityModel.getLongitude()
        )).toList();
    }
}
