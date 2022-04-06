package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Resource;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

  private final ResourceRepository repository;

  public UploadServiceImpl(ResourceRepository repository) {
    this.repository = repository;
  }

  @Override
  public Resource uploadResource(byte[] content) {
    Resource resource = new Resource().setContent(content);
    return repository.save(resource);
  }

  @Override
  public Resource getResource(String uuid) {
    return repository.findById(uuid).orElseThrow(
        () -> new ResourceNotFoundException(
            String.format("Resource with uuid %s not found", uuid)));
  }
}
