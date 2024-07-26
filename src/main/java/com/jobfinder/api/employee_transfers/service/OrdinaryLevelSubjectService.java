package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.dto.teaching.OrdinaryLevelSubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.OrdinaryLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.OrdinaryLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.OrdinaryLevelSubjectServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdinaryLevelSubjectService implements OrdinaryLevelSubjectServiceInterface {

    private final OrdinaryLevelSubjectRepository ordinaryLevelSubjectRepository;

    public OrdinaryLevelSubjectService(OrdinaryLevelSubjectRepository ordinaryLevelSubjectRepository) {
        this.ordinaryLevelSubjectRepository = ordinaryLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        Optional<OrdinaryLevelSubjectModel> ordinaryLevelSubject
                = this.ordinaryLevelSubjectRepository.findById(subjectId);
        if (ordinaryLevelSubject.isEmpty()) {
            return "";
        }
        return ordinaryLevelSubject.get().getSubject();
    }

    @Override
    public List<OrdinaryLevelSubjectDto> getSubjects() {
        List<OrdinaryLevelSubjectModel> ordinaryLevelSubjects = this.ordinaryLevelSubjectRepository.findAll();
        if (ordinaryLevelSubjects.isEmpty()) {
            return new ArrayList<>();
        }
        return ordinaryLevelSubjects.stream().map(ordinaryLevelSubjectModel ->
                        new OrdinaryLevelSubjectDto(
                                ordinaryLevelSubjectModel.getId(),
                                ordinaryLevelSubjectModel.getSubject())
                )
                .collect(Collectors.toList());
    }

    @Override
    public void createSubject(String subject) {
        this.ordinaryLevelSubjectRepository.save(new OrdinaryLevelSubjectModel(subject));
    }

    @Override
    public void deleteSubject(int subjectId) {
        this.ordinaryLevelSubjectRepository.deleteById(subjectId);
    }
}
