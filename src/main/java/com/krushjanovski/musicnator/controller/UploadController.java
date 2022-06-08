package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.BaseDto;
import com.krushjanovski.musicnator.entity.Resource;
import com.krushjanovski.musicnator.exception.UploadException;
import com.krushjanovski.musicnator.mapper.UploadMapper;
import com.krushjanovski.musicnator.service.UploadService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
      return mapper.map(
          service.uploadResource(file.getOriginalFilename(), file.getContentType(), file.getBytes()));
    } catch (Exception e) {
      throw new UploadException();
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<byte[]> getFile(@PathVariable String uuid) {
    Resource resource = service.getResource(uuid);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, resource.getType())
        .header(HttpHeaders.CONTENT_DISPOSITION,
            String.format("attachment; filename=\"%s\"", resource.getName()))
        .body(resource.getContent());
  }
}
