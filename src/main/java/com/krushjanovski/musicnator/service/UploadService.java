package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Resource;

public interface UploadService {

  Resource uploadResource(String name, String type, byte[] content);

  Resource getResource(String uuid);
}
