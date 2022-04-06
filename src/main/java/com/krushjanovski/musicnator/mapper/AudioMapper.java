package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.AudioDto;
import com.krushjanovski.musicnator.entity.Audio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AudioMapper {

  @Mapping(target = "categoryUuids", ignore = true)
  @Mapping(target = "audioResourceUuid", source = "audioResource.uuid")
  @Mapping(target = "imageResourceUuid", source = "imageResource.uuid")
  AudioDto map(Audio audio);

}
