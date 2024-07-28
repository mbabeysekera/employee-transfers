package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.common.DistrictDto;
import com.jobfinder.api.employee_transfers.model.common.DistrictModel;
import com.jobfinder.api.employee_transfers.repository.common.DistrictRepository;
import com.jobfinder.api.employee_transfers.service.common.DistrictServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class DistrictService implements DistrictServiceInterface {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public String getDistrict(int districtId) {
        log.info("Fetch district for ID: {}", districtId);
        Optional<DistrictModel> district = this.districtRepository.findById(districtId);
        if (district.isEmpty()) {
            log.info("District does not exists for ID: {}", districtId);
            return "";
        }
        log.info("Fetching district for ID: {} {}.", districtId,  ResponseStatusMessages.SUCCESS);
        return district.get().getDistrict();
    }

    @Override
    public List<DistrictDto> getDistricts() {
        log.info("Prepare districts");
        List<DistrictModel> districts = this.districtRepository.findAll();
        if (districts.isEmpty()) {
            log.info("Districts not exists in the system");
            return new ArrayList<>();
        }
        log.info("Fetching districts: {}", ResponseStatusMessages.SUCCESS);
        return districts.stream().map(districtModel -> new DistrictDto(
                districtModel.getId(),
                districtModel.getDistrict()
        )).toList();
    }
}
