package com.jobfinder.api.employee_transfers.repository.common;

import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetailsModel, Integer> {

    Optional<JobDetailsModel> findByUserId(int userId);
    void deleteByUserId(int userId);
}
