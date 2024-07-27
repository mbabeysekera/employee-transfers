package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.constant.ResponseStatusMessages;
import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.OrdinaryLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.OrdinaryLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.OrdinaryLevelSubjectServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class OrdinaryLevelSubjectService implements OrdinaryLevelSubjectServiceInterface {

    private final OrdinaryLevelSubjectRepository ordinaryLevelSubjectRepository;

    public OrdinaryLevelSubjectService(OrdinaryLevelSubjectRepository ordinaryLevelSubjectRepository) {
        this.ordinaryLevelSubjectRepository = ordinaryLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        log.info("Fetch ordinary level subject for ID: {}", subjectId);
        Optional<OrdinaryLevelSubjectModel> ordinaryLevelSubject
                = this.ordinaryLevelSubjectRepository.findById(subjectId);
        if (ordinaryLevelSubject.isEmpty()) {
            log.info("Subject does not exists for ID: {}", subjectId);
            return "";
        }
        log.info("Fetching ordinary level subject for ID: {}", ResponseStatusMessages.SUCCESS);
        return ordinaryLevelSubject.get().getSubject();
    }

    @Override
    public List<SubjectDto> getSubjects() {
        log.info("Prepare ordinary level subjects");
        List<OrdinaryLevelSubjectModel> ordinaryLevelSubjects = this.ordinaryLevelSubjectRepository.findAll();
        if (ordinaryLevelSubjects.isEmpty()) {
            return new ArrayList<>();
        }
        log.info("Fetching ordinary level subjects: {}", ResponseStatusMessages.SUCCESS);
        return ordinaryLevelSubjects.stream().map(ordinaryLevelSubjectModel ->
                        new SubjectDto(
                                ordinaryLevelSubjectModel.getId(),
                                ordinaryLevelSubjectModel.getSubject())
                )
                .toList();
    }

    @Override
    public void createSubject(String subject) {
        log.info("Add ordinary level subject: {}.", subject);
        this.ordinaryLevelSubjectRepository.save(new OrdinaryLevelSubjectModel(subject));
        log.info("Creating ordinary level subject: {}.", ResponseStatusMessages.SUCCESS);
    }

    @Override
    public void deleteSubject(int subjectId) {
        log.info("Delete ordinary level subject for ID: {}.", subjectId);
        this.ordinaryLevelSubjectRepository.deleteById(subjectId);
        log.info("Deleting ordinary level subject: {}.", ResponseStatusMessages.SUCCESS);
    }
}
