package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.model.common.DivisionModel;
import com.jobfinder.api.employee_transfers.repository.common.DivisionRepository;
import com.jobfinder.api.employee_transfers.service.common.DivisionServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DivisionService implements DivisionServiceInterface {

    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public String getDivision(int divisionId) {
        Optional<DivisionModel> division = this.divisionRepository.findById(divisionId);
        if (division.isEmpty()) {
            return "";
        }
        return division.get().getDivision();
    }

    @Override
    public void addDivision(String division) {
        this.divisionRepository.save(new DivisionModel(division));
    }
}
