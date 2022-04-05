package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.UserDto;
import com.krushjanovski.musicnator.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "password", ignore = true)
  @Mapping(target = "roleId", ignore = true)
  UserDto map(User user);
}
