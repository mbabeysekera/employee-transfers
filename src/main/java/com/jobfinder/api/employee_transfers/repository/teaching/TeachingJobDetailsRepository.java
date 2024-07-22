package com.jobfinder.api.employee_transfers.repository.teaching;

import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingJobDetailsRepository extends JpaRepository<TeachingJobDetailsModel, Integer> {
}
