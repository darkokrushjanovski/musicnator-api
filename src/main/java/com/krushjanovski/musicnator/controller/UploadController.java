package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.BaseDto;
import com.krushjanovski.musicnator.exception.UploadException;
import com.krushjanovski.musicnator.mapper.UploadMapper;
import com.krushjanovski.musicnator.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/uploads")
public class UploadController {

  private final UploadService service;
  private final UploadMapper mapper;

  public UploadController(UploadService service,
      UploadMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public BaseDto uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      return mapper.map(service.uploadResource(file.getBytes()));
    } catch (Exception e) {
      throw new UploadException();
    }
  }
}
