package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.repository.AudioUserProjection;
import java.util.List;

public interface AudioService {

  void createAudio(String title, String description, List<String> categoryUuids,
      String audioResourceUuid, String imageResourceUuid);

  void updateAudio(String uuid, String title, String description, List<String> categoryUuids,
      String audioResourceUuid, String imageResourceUuid);

  void deleteAudio(String uuid);

  Audio getAudio(String uuid);

  List<Audio> getAudios();

  List<Audio> getAudiosByUserUuid(String userUuid);

  List<AudioUserProjection> getAudiosByCategory(String categoryTitle);
}
