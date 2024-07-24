package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.model.common.ProvinceModel;
import com.jobfinder.api.employee_transfers.repository.common.ProvinceRepository;
import com.jobfinder.api.employee_transfers.service.common.ProvinceServiceInterface;

import java.util.Optional;

public class ProvinceService implements ProvinceServiceInterface {

    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public String getProvince(int provinceId) {
        Optional<ProvinceModel> province = this.provinceRepository.findById(provinceId);
        if (province.isEmpty()) {
            return "";
        }
        return province.get().getProvince();
    }

    @Override
    public void addProvince(String province) {
        this.provinceRepository.save(new ProvinceModel(province));
    }
}
