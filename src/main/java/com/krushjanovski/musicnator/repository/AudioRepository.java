package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AudioRepository extends JpaRepository<Audio, String> {

  List<Audio> findAllByCreatedBy(String userUuid);

  @Query(value = "SELECT a as audio, u as user FROM Audio a "
      + "LEFT JOIN User u ON a.createdBy = u.uuid "
      + "LEFT JOIN a.categories ac WHERE ac.uuid = :categoryUuid")
  List<AudioUserProjection> findAllByCategory(String categoryUuid);
}
