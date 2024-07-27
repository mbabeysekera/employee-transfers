package com.jobfinder.api.employee_transfers.controller.teaching;

import com.jobfinder.api.employee_transfers.dto.response.SubjectResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import com.jobfinder.api.employee_transfers.service.AdvancedLevelSubjectService;
import com.jobfinder.api.employee_transfers.service.OrdinaryLevelSubjectService;
import com.jobfinder.api.employee_transfers.service.PrimaryLevelSubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "subject")
public class SubjectController {

    private final AdvancedLevelSubjectService advancedLevelSubjectService;
    private final OrdinaryLevelSubjectService ordinaryLevelSubjectService;
    private final PrimaryLevelSubjectService primaryLevelSubjectService;

    public SubjectController(AdvancedLevelSubjectService advancedLevelSubjectService,
                             OrdinaryLevelSubjectService ordinaryLevelSubjectService,
                             PrimaryLevelSubjectService primaryLevelSubjectService) {
        this.advancedLevelSubjectService = advancedLevelSubjectService;
        this.ordinaryLevelSubjectService = ordinaryLevelSubjectService;
        this.primaryLevelSubjectService = primaryLevelSubjectService;
    }

    @GetMapping(path = "primaryLevel")
    public ResponseEntity<SubjectResponseDto> getPrimaryLevelSubjects() {
        List<SubjectDto> subjects = this.primaryLevelSubjectService.getSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SubjectResponseDto(
                        "primary",
                        subjects
                )
        );
    }

    @GetMapping(path = "ordinaryLevel")
    public ResponseEntity<SubjectResponseDto> getOrdinaryLevelSubjects() {
        List<SubjectDto> subjects = this.ordinaryLevelSubjectService.getSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SubjectResponseDto(
                        "ordinary",
                        subjects
                )
        );
    }

    @GetMapping(path = "advancedLevel")
    public ResponseEntity<SubjectResponseDto> getAdvancedLevelSubjects() {
        List<SubjectDto> subjects = this.advancedLevelSubjectService.getSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SubjectResponseDto(
                        "advanced",
                        subjects
                )
        );
    }
}
