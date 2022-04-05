package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.dto.BaseDto;
import com.krushjanovski.musicnator.entity.Resource;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

  private final ResourceRepository resourceRepository;

  public UploadServiceImpl(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  @Override
  public Resource uploadResource(byte[] content) {
    Resource resource = new Resource().setContent(content);
    return resourceRepository.save(resource);
  }

  @Override
  public Resource getResource(Long id) {
    return resourceRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(String.format("Resource with id %d not found", id)));
  }
}
