package com.jobfinder.api.employee_transfers.repository.common;

import com.jobfinder.api.employee_transfers.model.common.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Integer> {
}
