package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.model.common.CityModel;
import com.jobfinder.api.employee_transfers.repository.common.CityRepository;
import com.jobfinder.api.employee_transfers.service.common.CityServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements CityServiceInterface {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public String getCity(int cityId) {
        Optional<CityModel> city = this.cityRepository.findById(cityId);
        if (city.isEmpty()) {
            return "";
        }
        return city.get().getCity();
    }

    @Override
    public void addCity(String city) {
        this.cityRepository.save(new CityModel(city));
    }
}
