package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Long> {
}
