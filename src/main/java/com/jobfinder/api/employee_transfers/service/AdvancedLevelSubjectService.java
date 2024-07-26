package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.dto.teaching.AdvanceLevelSubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.AdvancedLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.AdvancedLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.AdvancedLevelSubjectServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvancedLevelSubjectService implements AdvancedLevelSubjectServiceInterface {

    private final AdvancedLevelSubjectRepository advancedLevelSubjectRepository;

    public AdvancedLevelSubjectService(AdvancedLevelSubjectRepository advancedLevelSubjectRepository) {
        this.advancedLevelSubjectRepository = advancedLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        Optional<AdvancedLevelSubjectModel> advancedLevelSubject
                = this.advancedLevelSubjectRepository.findById(subjectId);
        if (advancedLevelSubject.isEmpty()) {
            return "";
        }
        return advancedLevelSubject.get().getSubject();
    }

    @Override
    public List<AdvanceLevelSubjectDto> getSubjects() {
        List<AdvancedLevelSubjectModel> advanceLevelSubjects = this.advancedLevelSubjectRepository.findAll();
        if (advanceLevelSubjects.isEmpty()) {
            return new ArrayList<>();
        }
        return advanceLevelSubjects.stream().map(advancedLevelSubjectModel -> new AdvanceLevelSubjectDto(
                advancedLevelSubjectModel.getId(),
                advancedLevelSubjectModel.getSubject()
        )).collect(Collectors.toList());
    }

    @Override
    public void createSubject(String subject) {
        this.advancedLevelSubjectRepository.save(new AdvancedLevelSubjectModel(
                subject
        ));
    }

    @Override
    public void deleteSubject(int subjectId) {
        this.advancedLevelSubjectRepository.deleteById(subjectId);
    }
}
