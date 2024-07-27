package com.jobfinder.api.employee_transfers.repository.common;

import com.jobfinder.api.employee_transfers.model.common.ProvinceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceModel, Integer> {
}
