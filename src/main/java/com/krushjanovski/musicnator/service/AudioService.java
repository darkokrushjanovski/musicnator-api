package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Audio;
import java.util.List;
import java.util.Set;

public interface AudioService {

  void createAudio(String title, String description, List<Long> categories, Long resourceId);

  void updateAudio(Long id, String title, String description, List<Long> categories,
      Long resourceId);

  void deleteAudio(Long id);

  Audio getAudio(Long id);

  List<Audio> getAudios();
}