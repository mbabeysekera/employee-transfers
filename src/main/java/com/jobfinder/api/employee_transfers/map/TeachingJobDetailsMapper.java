package com.jobfinder.api.employee_transfers.map;

import com.jobfinder.api.employee_transfers.dto.teaching.TeachingJobDetailsDto;
import com.jobfinder.api.employee_transfers.model.teaching.TeachingJobDetailsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeachingJobDetailsMapper {
    TeachingJobDetailsMapper INSTANCE = Mappers.getMapper(TeachingJobDetailsMapper.class);

    @Mapping(source = "primarySubjectForPLevel", target = "primarySubjectForPLevel")
    @Mapping(source = "secondarySubjectForPLevel", target = "secondarySubjectForPLevel")
    @Mapping(source = "ternarySubjectForPLevel", target = "ternarySubjectForPLevel")
    @Mapping(source = "primarySubjectForOLevel", target = "primarySubjectForOLevel")
    @Mapping(source = "secondarySubjectForOLevel", target = "secondarySubjectForOLevel")
    @Mapping(source = "ternarySubjectForOLevel", target = "ternarySubjectForOLevel")
    @Mapping(source = "primarySubjectForALevel", target = "primarySubjectForALevel")
    @Mapping(source = "secondarySubjectForALevel", target = "secondarySubjectForALevel")
    @Mapping(source = "ternarySubjectForALevel", target = "ternarySubjectForALevel")
    @Mapping(source = "createdAt", target = "createdAt")
    TeachingJobDetailsModel teachingJobDetailsDtoToTeachingJobDetailsModel(TeachingJobDetailsDto teachingJobDetailsDto);

    @Mapping(source = "primarySubjectForPLevel", target = "primarySubjectForPLevel")
    @Mapping(source = "secondarySubjectForPLevel", target = "secondarySubjectForPLevel")
    @Mapping(source = "ternarySubjectForPLevel", target = "ternarySubjectForPLevel")
    @Mapping(source = "primarySubjectForOLevel", target = "primarySubjectForOLevel")
    @Mapping(source = "secondarySubjectForOLevel", target = "secondarySubjectForOLevel")
    @Mapping(source = "ternarySubjectForOLevel", target = "ternarySubjectForOLevel")
    @Mapping(source = "primarySubjectForALevel", target = "primarySubjectForALevel")
    @Mapping(source = "secondarySubjectForALevel", target = "secondarySubjectForALevel")
    @Mapping(source = "ternarySubjectForALevel", target = "ternarySubjectForALevel")
    @Mapping(source = "createdAt", target = "createdAt")
    TeachingJobDetailsDto teachingJobDetailsModelToTeachingJobDetailsDto(TeachingJobDetailsModel teachingJobDetailsModel);

}
