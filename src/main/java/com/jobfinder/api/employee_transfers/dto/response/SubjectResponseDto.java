package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.dto.teaching.SubjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponseDto {
    private String level;
    private List<SubjectDto> subjects;
}