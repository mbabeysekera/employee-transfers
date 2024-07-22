package com.jobfinder.api.employee_transfers.repository.teaching;

import com.jobfinder.api.employee_transfers.model.teaching.PrimaryLevelSubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryLevelSubjectRepository extends JpaRepository<PrimaryLevelSubjectModel, Integer> {
}
