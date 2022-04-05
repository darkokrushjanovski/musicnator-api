package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.AudioDto;
import com.krushjanovski.musicnator.entity.Audio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AudioMapper {

  AudioDto map(Audio audio);

}
