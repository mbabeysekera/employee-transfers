package com.jobfinder.api.employee_transfers.dto.common;

import com.jobfinder.api.employee_transfers.constant.enums.JobCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCategoryListDto {
    private List<JobCategory> jobCategories;
}
