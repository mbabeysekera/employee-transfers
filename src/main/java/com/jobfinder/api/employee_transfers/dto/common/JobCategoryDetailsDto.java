package com.jobfinder.api.employee_transfers.dto.common;

import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCategoryDetailsDto<T> {
    private JobCategory category;
    private T details;
}
