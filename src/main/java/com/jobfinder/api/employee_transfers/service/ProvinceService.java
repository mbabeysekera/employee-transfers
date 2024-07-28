package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.common.ProvinceDto;
import com.jobfinder.api.employee_transfers.model.common.ProvinceModel;
import com.jobfinder.api.employee_transfers.repository.common.ProvinceRepository;
import com.jobfinder.api.employee_transfers.service.common.ProvinceServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ProvinceService implements ProvinceServiceInterface {

    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public String getProvince(int provinceId) {
        log.info("Fetch province for ID: {}", provinceId);
        Optional<ProvinceModel> province = this.provinceRepository.findById(provinceId);
        if (province.isEmpty()) {
            log.info("Province does not exists for ID: {}", provinceId);
            return "";
        }
        log.info("Fetching province for ID: {} {}.", provinceId,  ResponseStatusMessages.SUCCESS);
        return province.get().getProvince();
    }

    @Override
    public List<ProvinceDto> getProvinces() {
        log.info("Prepare provinces");
        List<ProvinceModel> provinces = this.provinceRepository.findAll();
        if (provinces.isEmpty()) {
            log.info("Provinces not exists in the system");
            return new ArrayList<>();
        }
        log.info("Fetching provinces: {}", ResponseStatusMessages.SUCCESS);
        return provinces.stream().map(provinceModel -> new ProvinceDto(
                provinceModel.getId(),
                provinceModel.getProvince(),
                provinceModel.getCapitol()
        )).toList();
    }
}
