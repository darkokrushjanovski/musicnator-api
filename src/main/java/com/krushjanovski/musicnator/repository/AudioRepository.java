package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, String> {

  List<Audio> findAllByCreatedBy(String userUuid);

  List<Audio> findAllByCategoriesIn(List<Category> categoryUuid);
}
