package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.RoleDto;
import com.krushjanovski.musicnator.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  RoleDto map(Role role);

}
