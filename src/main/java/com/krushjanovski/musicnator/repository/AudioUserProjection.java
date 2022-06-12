package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Audio;
import com.krushjanovski.musicnator.entity.User;

public interface AudioUserProjection {

  Audio getAudio();

  User getUser();

}
