package com.jobfinder.api.employee_transfers.dto.response;

import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailsResponseDto<J> {

    private JobDetailsDto jobDetails;
    private J categoryDetails;
}
