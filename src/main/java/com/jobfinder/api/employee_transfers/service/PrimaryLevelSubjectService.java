package com.jobfinder.api.employee_transfers.service;

import com.jobfinder.api.employee_transfers.dto.teaching.PrimaryLevelSubjectDto;
import com.jobfinder.api.employee_transfers.model.teaching.PrimaryLevelSubjectModel;
import com.jobfinder.api.employee_transfers.repository.teaching.PrimaryLevelSubjectRepository;
import com.jobfinder.api.employee_transfers.service.teaching.PrimaryLevelSubjectServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrimaryLevelSubjectService implements PrimaryLevelSubjectServiceInterface {

    private final PrimaryLevelSubjectRepository primaryLevelSubjectRepository;

    public PrimaryLevelSubjectService(PrimaryLevelSubjectRepository primaryLevelSubjectRepository) {
        this.primaryLevelSubjectRepository = primaryLevelSubjectRepository;
    }

    @Override
    public String getSubject(int subjectId) {
        Optional<PrimaryLevelSubjectModel> primaryLevelSubject = this.primaryLevelSubjectRepository.findById(subjectId);
        if (primaryLevelSubject.isEmpty()) {
            return "";
        }
        return primaryLevelSubject.get().getSubject();
    }

    @Override
    public List<PrimaryLevelSubjectDto> getSubjects() {
        List<PrimaryLevelSubjectModel> primaryLevelSubjects = this.primaryLevelSubjectRepository.findAll();
        if (primaryLevelSubjects.isEmpty()) {
            return new ArrayList<>();
        }
        return primaryLevelSubjects.stream().map(primaryLevelSubjectModel -> new PrimaryLevelSubjectDto(
                primaryLevelSubjectModel.getId(),
                primaryLevelSubjectModel.getSubject()
        )).collect(Collectors.toList());
    }

    @Override
    public void createSubject(String subject) {
        this.primaryLevelSubjectRepository.save(new PrimaryLevelSubjectModel(subject));
    }

    @Override
    public void deleteSubject(int subjectId) {
        this.primaryLevelSubjectRepository.deleteById(subjectId);
    }
}
