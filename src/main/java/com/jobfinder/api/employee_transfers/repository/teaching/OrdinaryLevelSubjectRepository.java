package com.jobfinder.api.employee_transfers.repository.teaching;

import com.jobfinder.api.employee_transfers.model.teaching.OrdinaryLevelSubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinaryLevelSubjectRepository extends JpaRepository<OrdinaryLevelSubjectModel, Integer> {
}
