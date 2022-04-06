package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.entity.Resource;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.AudioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceImpl implements AudioService {

  private final AudioRepository repository;
  private final CategoryService categoryService;
  private final UploadService uploadService;

  public AudioServiceImpl(AudioRepository repository,
      CategoryService categoryService,
      UploadService uploadService) {
    this.repository = repository;
    this.categoryService = categoryService;
    this.uploadService = uploadService;
  }

  @Override
  public void createAudio(String title, String description, List<String> categoryUuids,
      String audioResourceUuid, String imageResourceUuid) {
    Resource audioResource = uploadService.getResource(audioResourceUuid);
    Resource imageResource = uploadService.getResource(imageResourceUuid);
    Audio audio = new Audio()
        .setTitle(title)
        .setDescription(description)
        .setCategories(categoryService.getCategoriesByUuid(categoryUuids))
        .setAudioResource(audioResource)
        .setImageResource(imageResource);

    repository.save(audio);
  }

  @Override
  public void updateAudio(String uuid, String title, String description, List<String> categoryUuids,
      String audioResourceUuid, String imageResourceUuid) {
    Resource audioResource = uploadService.getResource(audioResourceUuid);
    Resource imageResource = uploadService.getResource(imageResourceUuid);

    Audio audio = getAudio(uuid);
    audio.setTitle(title);
    audio.setDescription(description);
    audio.setCategories(categoryService.getCategoriesByUuid(categoryUuids));
    audio.setAudioResource(audioResource);
    audio.setImageResource(imageResource);

    repository.save(audio);
  }

  @Override
  public void deleteAudio(String uuid) {
    Audio audio = getAudio(uuid);

    repository.delete(audio);
  }

  @Override
  public Audio getAudio(String uuid) {
    return repository.findById(uuid).orElseThrow(
        () -> new ResourceNotFoundException(String.format("Audio with uuid %s not found", uuid)));
  }

  @Override
  public List<Audio> getAudios() {
    return repository.findAll();
  }

  @Override
  public List<Audio> getAudiosByUserUuid(String userUuid) {
    return repository.findAllByCreatedBy(userUuid);
  }
}
