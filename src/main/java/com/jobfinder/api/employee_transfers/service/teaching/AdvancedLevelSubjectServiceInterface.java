package com.jobfinder.api.employee_transfers.service.teaching;


import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;

import java.util.List;

public interface AdvancedLevelSubjectServiceInterface {


    String getSubject(int subjectId);

    List<SubjectDto> getSubjects();

    void createSubject(String subject);

    void deleteSubject(int subjectId);
}
