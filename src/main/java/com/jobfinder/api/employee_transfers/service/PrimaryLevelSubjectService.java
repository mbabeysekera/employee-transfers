package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.PrimaryLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.PrimaryLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.PrimaryLevelSubjectServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PrimaryLevelSubjectService implements PrimaryLevelSubjectServiceInterface {

    private final PrimaryLevelSubjectRepository primaryLevelSubjectRepository;

    public PrimaryLevelSubjectService(PrimaryLevelSubjectRepository primaryLevelSubjectRepository) {
        this.primaryLevelSubjectRepository = primaryLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        log.info("Fetch primary level subject for ID: {}", subjectId);
        Optional<PrimaryLevelSubjectModel> primaryLevelSubject = this.primaryLevelSubjectRepository.findById(subjectId);
        if (primaryLevelSubject.isEmpty()) {
            log.info("Subject does not exists for ID: {}", subjectId);
            return "";
        }
        log.info("Fetching primary level subject: {} {}.", subjectId,  ResponseStatusMessages.SUCCESS);
        return primaryLevelSubject.get().getSubject();
    }

    @Override
    public List<SubjectDto> getSubjects() {
        log.info("Prepare primary level subjects");
        List<PrimaryLevelSubjectModel> primaryLevelSubjects = this.primaryLevelSubjectRepository.findAll();
        if (primaryLevelSubjects.isEmpty()) {
            log.info("Subjects not exists in the system for Primary Level");
            return new ArrayList<>();
        }
        log.info("Fetching primary level subjects: {}", ResponseStatusMessages.SUCCESS);
        return primaryLevelSubjects.stream().map(primaryLevelSubjectModel -> new SubjectDto(
                primaryLevelSubjectModel.getId(),
                primaryLevelSubjectModel.getSubject()
        )).toList();
    }

    @Override
    public void createSubject(String subject) {
        log.info("Add primary level subject: {}.", subject);
        this.primaryLevelSubjectRepository.save(new PrimaryLevelSubjectModel(subject));
        log.info("Creating primary level subject: {} {}.", subject,  ResponseStatusMessages.SUCCESS);
    }

    @Override
    public void deleteSubject(int subjectId) {
        log.info("Delete primary level subject for ID: {}.", subjectId);
        this.primaryLevelSubjectRepository.deleteById(subjectId);
        log.info("Deleting primary level subject: {} {}.", subjectId,  ResponseStatusMessages.SUCCESS);
    }
}
