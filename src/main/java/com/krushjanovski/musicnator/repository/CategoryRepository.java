package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
