package com.jobfinder.api.employee_transfers.service.teaching;

public interface PrimaryLevelSubjectServiceInterface {
    String getSubject(int subjectId);

    void createSubject(String subject);

    void deleteSubject(int subjectId);
}
