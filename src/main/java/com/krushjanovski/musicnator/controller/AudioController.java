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
    service.createAudio(audioDto.getTitle(), audioDto.getDescription(), audioDto.getCategoryIds(),
        audioDto.getResourceId());
  }

  @PutMapping("/{id}")
  public void updateAudio(@PathVariable Long id, @RequestBody AudioDto audioDto) {
    service.updateAudio(id, audioDto.getTitle(), audioDto.getDescription(),
        audioDto.getCategoryIds(), audioDto.getResourceId());
  }

  @DeleteMapping("/{id}")
  public void deleteAudio(@PathVariable Long id) {
    service.deleteAudio(id);
  }

  @GetMapping("/{id}")
  public AudioDto getAudio(@PathVariable Long id) {
    return mapper.map(service.getAudio(id));
  }

  @GetMapping
  public List<AudioDto> getAudios() {
    return service.getAudios().stream().map(mapper::map).toList();
  }
}
