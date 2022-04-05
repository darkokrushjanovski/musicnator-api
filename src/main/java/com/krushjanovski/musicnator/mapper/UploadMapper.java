package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.BaseDto;
import com.krushjanovski.musicnator.entity.Resource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UploadMapper {

  BaseDto map(Resource resource);

}
