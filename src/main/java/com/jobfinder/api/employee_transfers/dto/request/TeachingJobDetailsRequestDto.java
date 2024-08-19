package com.jobfinder.api.employee_transfers.dto.request;

import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachingJobDetailsRequestDto extends TeachingJobDetailsDto {

    private String additionalDetails;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
