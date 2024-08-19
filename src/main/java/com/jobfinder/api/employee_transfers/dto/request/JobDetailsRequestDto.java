package com.jobfinder.api.employee_transfers.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailsRequestDto extends JobDetailsDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TeachingJobDetailsRequestDto teachingJobDetails;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
