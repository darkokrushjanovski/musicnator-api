package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Audio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, String> {

  List<Audio> findAllByCreatedBy(String userUuid);
}
