package com.jobfinder.api.employee_transfers.controller.teaching;

import com.jobfinder.api.employee_transfers.dto.response.SubjectResponseDto;
import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import com.jobfinder.api.employee_transfers.service.AdvancedLevelSubjectService;
import com.jobfinder.api.employee_transfers.service.OrdinaryLevelSubjectService;
import com.jobfinder.api.employee_transfers.service.PrimaryLevelSubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<SubjectResponseDto<SubjectDto>> getPrimaryLevelSubjects() {
        return ResponseEntity.ok(new SubjectResponseDto<>("primary",
                this.primaryLevelSubjectService.getSubjects()));
    }

    @GetMapping(path = "ordinaryLevel")
    public ResponseEntity<SubjectResponseDto<SubjectDto>> getOrdinaryLevelSubjects() {
        return ResponseEntity.ok(new SubjectResponseDto<>("ordinary",
                this.ordinaryLevelSubjectService.getSubjects()));
    }

    @GetMapping(path = "advancedLevel")
    public ResponseEntity<SubjectResponseDto<SubjectDto>> getAdvancedLevelSubjects() {
        return ResponseEntity.ok(new SubjectResponseDto<>("advanced",
                this.advancedLevelSubjectService.getSubjects()));
    }
}
