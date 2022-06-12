package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.AudioDto;
import com.krushjanovski.musicnator.mapper.AudioMapper;
import com.krushjanovski.musicnator.service.AudioService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audios")
public class AudioController {

  private final AudioService service;
  private final AudioMapper mapper;

  public AudioController(AudioService service,
      AudioMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public void createAudio(@RequestBody AudioDto audioDto) {
    service.createAudio(audioDto.getTitle(), audioDto.getDescription(), audioDto.getCategoryUuids(),
        audioDto.getAudioResourceUuid(), audioDto.getImageResourceUuid());
  }

  @PutMapping("/{uuid}")
  public void updateAudio(@PathVariable String uuid, @RequestBody AudioDto audioDto) {
    service.updateAudio(uuid, audioDto.getTitle(), audioDto.getDescription(),
        audioDto.getCategoryUuids(), audioDto.getAudioResourceUuid(),
        audioDto.getImageResourceUuid());
  }

  @DeleteMapping("/{uuid}")
  public void deleteAudio(@PathVariable String uuid) {
    service.deleteAudio(uuid);
  }

  @GetMapping("/{uuid}")
  public AudioDto getAudio(@PathVariable String uuid) {
    return mapper.map(service.getAudio(uuid));
  }

  @GetMapping
  public List<AudioDto> getAudios() {
    return service.getAudios().stream().map(mapper::map).collect(Collectors.toList());
  }

  @GetMapping("/user/{uuid}")
  public List<AudioDto> getAudiosByUser(@PathVariable String uuid) {
    return service.getAudiosByUserUuid(uuid).stream().map(mapper::map).collect(Collectors.toList());
  }

  @GetMapping("/categories/{title}")
  public List<AudioDto> getAudiosByCategory(@PathVariable String title) {
    return service.getAudiosByCategory(title).stream().map(audioUserProjection -> mapper.map(
            audioUserProjection.getAudio(), audioUserProjection.getUser()))
        .collect(Collectors.toList());
  }
}
