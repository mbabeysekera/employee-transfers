package com.jobfinder.api.employee_transfers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetadataResponseDto<T> {
    private String description;
    private T metadata;
}
