package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Resource;

public interface UploadService {

  Resource uploadResource(byte[] content);

  Resource getResource(Long id);
}
