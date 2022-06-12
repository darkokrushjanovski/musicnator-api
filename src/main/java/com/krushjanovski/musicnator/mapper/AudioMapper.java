package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.AudioDto;
import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AudioMapper {

  @Mapping(target = "categoryUuids", ignore = true)
  @Mapping(target = "audioResourceUuid", source = "audioResource.uuid")
  @Mapping(target = "imageResourceUuid", source = "imageResource.uuid")
  AudioDto map(Audio audio);

  @Mapping(target = "uuid", source = "audio.uuid")
  @Mapping(target = "createdAt", source = "audio.createdAt")
  @Mapping(target = "updatedAt", source = "audio.updatedAt")
  @Mapping(target = "categoryUuids", ignore = true)
  @Mapping(target = "audioResourceUuid", source = "audio.audioResource.uuid")
  @Mapping(target = "imageResourceUuid", source = "audio.imageResource.uuid")
  AudioDto map(Audio audio, User user);
}
