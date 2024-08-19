package com.jobfinder.api.employee_transfers.repository.common;

import com.jobfinder.api.employee_transfers.dto.common.MatchingCriteriaDto;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobDetailsRepository extends JpaRepository<JobDetailsModel, Integer> {

    Optional<JobDetailsModel> findByUserId(int userId);

    void deleteByUserId(int userId);

    @Query(value =
            "SELECT u FROM JobDetailsModel u WHERE " +
                    "u.currentProvince = :#{#criteria.nextProvinceLookingFor} and " +
                    "u.currentDivision = :#{#criteria.nextDivisionLookingFor}")
    List<JobDetailsModel> findJobDetailsByMatchingCriteria(@Param("criteria") MatchingCriteriaDto matchingCriteria);
}
