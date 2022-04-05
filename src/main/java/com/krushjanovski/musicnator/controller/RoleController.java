package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.RoleDto;
import com.krushjanovski.musicnator.mapper.RoleMapper;
import com.krushjanovski.musicnator.service.RoleService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

  private final RoleService service;
  private final RoleMapper mapper;

  public RoleController(RoleService service, RoleMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @GetMapping
  public List<RoleDto> getRoles() {
    return service.getRoles().stream().map(mapper::map).collect(Collectors.toList());
  }
}
