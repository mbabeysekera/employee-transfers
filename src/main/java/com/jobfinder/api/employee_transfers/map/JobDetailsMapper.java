package com.jobfinder.api.employee_transfers.map;

import com.jobfinder.api.employee_transfers.dto.common.JobDetailsDto;
import com.jobfinder.api.employee_transfers.model.common.JobDetailsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobDetailsMapper {
    JobDetailsMapper INSTANCE = Mappers.getMapper(JobDetailsMapper.class);

    @Mapping(source = "seniority", target = "seniority")
    @Mapping(source = "servicePeriod", target = "servicePeriod")
    @Mapping(source = "currentProvince", target = "currentProvince")
    @Mapping(source = "currentDivision", target = "currentDivision")
    @Mapping(source = "currentCity", target = "currentCity")
    @Mapping(source = "nextProvince", target = "nextProvince")
    @Mapping(source = "nextDivision", target = "nextDivision")
    @Mapping(source = "nextCity", target = "nextCity")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "educationQualification", target = "educationQualification")
    @Mapping(source = "currentEmployer", target = "currentEmployer")
    JobDetailsDto jobDetailsEntityToJobDetailsDto(JobDetailsModel jobDetailsModel);

    @Mapping(source = "seniority", target = "seniority")
    @Mapping(source = "servicePeriod", target = "servicePeriod")
    @Mapping(source = "currentProvince", target = "currentProvince")
    @Mapping(source = "currentDivision", target = "currentDivision")
    @Mapping(source = "currentCity", target = "currentCity")
    @Mapping(source = "nextProvince", target = "nextProvince")
    @Mapping(source = "nextDivision", target = "nextDivision")
    @Mapping(source = "nextCity", target = "nextCity")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "educationQualification", target = "educationQualification")
    @Mapping(source = "currentEmployer", target = "currentEmployer")
    JobDetailsModel jobDetailsDtoToJobDetailsModel(JobDetailsDto jobDetailsDto);
}
