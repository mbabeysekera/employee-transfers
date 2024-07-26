package com.jobfinder.api.employee_transfers.service.teaching;
import com.jobfinder.api.employee_transfers.dto.teaching.OrdinaryLevelSubjectDto;

import java.util.List;

public interface OrdinaryLevelSubjectServiceInterface {
    String getSubject(int subjectId);

    List<OrdinaryLevelSubjectDto> getSubjects();

    void createSubject(String subject);

    void deleteSubject(int subjectId);
}
