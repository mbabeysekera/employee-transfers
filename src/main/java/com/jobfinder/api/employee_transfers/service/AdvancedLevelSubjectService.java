package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.AdvancedLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.AdvancedLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.AdvancedLevelSubjectServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class AdvancedLevelSubjectService implements AdvancedLevelSubjectServiceInterface {

    private final AdvancedLevelSubjectRepository advancedLevelSubjectRepository;

    public AdvancedLevelSubjectService(AdvancedLevelSubjectRepository advancedLevelSubjectRepository) {
        this.advancedLevelSubjectRepository = advancedLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        log.info("Fetch advanced level subject for ID: {}", subjectId);
        Optional<AdvancedLevelSubjectModel> advancedLevelSubject
                = this.advancedLevelSubjectRepository.findById(subjectId);
        if (advancedLevelSubject.isEmpty()) {
            log.info("Subject does not exists for ID: {}", subjectId);
            return "";
        }
        log.info("Fetching advanced level subject: {} {}.", subjectId,  ResponseStatusMessages.SUCCESS);
        return advancedLevelSubject.get().getSubject();
    }

    @Override
    public List<SubjectDto> getSubjects() {
        log.info("Prepare advanced level subjects");
        List<AdvancedLevelSubjectModel> advanceLevelSubjects = this.advancedLevelSubjectRepository.findAll();
        if (advanceLevelSubjects.isEmpty()) {
            log.info("Subjects not exists in the system for Advanced Level");
            return new ArrayList<>();
        }
        log.info("Fetching advanced level subjects: {}", ResponseStatusMessages.SUCCESS);
        return advanceLevelSubjects.stream().map(advancedLevelSubjectModel -> new SubjectDto(
                advancedLevelSubjectModel.getId(),
                advancedLevelSubjectModel.getSubject()
        )).toList();
    }

    @Override
    public void createSubject(String subject) {
        log.info("Add advanced level subject: {}.", subject);
        this.advancedLevelSubjectRepository.save(new AdvancedLevelSubjectModel(
                subject
        ));
        log.info("Creating advanced level subject: {} {}.", subject,  ResponseStatusMessages.SUCCESS);
    }

    @Override
    public void deleteSubject(int subjectId) {
        log.info("Delete advanced level subject for ID: {}.", subjectId);
        this.advancedLevelSubjectRepository.deleteById(subjectId);
        log.info("Deleting advanced level subject: {} {}.", subjectId,  ResponseStatusMessages.SUCCESS);
    }
}
