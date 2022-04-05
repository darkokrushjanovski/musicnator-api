package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.AudioRepository;
import com.krushjanovski.musicnator.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceImpl implements AudioService {

  private final AudioRepository audioRepository;
  private final CategoryRepository categoryRepository;

  public AudioServiceImpl(AudioRepository audioRepository,
      CategoryRepository categoryRepository) {
    this.audioRepository = audioRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void createAudio(String title, String description, List<Long> categories,
      Long resourceId) {
    Audio audio = new Audio()
        .setTitle(title)
        .setDescription(description)
        .setCategories(categoryRepository.findAllById(categories))
        .setResourceId(resourceId);

    audioRepository.save(audio);
  }

  @Override
  public void updateAudio(Long id, String title, String description, List<Long> categories,
      Long resourceId) {
    Audio audio = getAudio(id);
    audio.setTitle(title);
    audio.setDescription(description);
    audio.setCategories(categoryRepository.findAllById(categories));
    audio.setResourceId(resourceId);

    audioRepository.save(audio);
  }

  @Override
  public void deleteAudio(Long id) {
    Audio audio = getAudio(id);

    audioRepository.delete(audio);
  }

  @Override
  public Audio getAudio(Long id) {
    return audioRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(String.format("Audio with id %d not found", id)));
  }

  @Override
  public List<Audio> getAudios() {
    return audioRepository.findAll();
  }
}
