package com.krushjanovski.musicnator.mapper;

import com.krushjanovski.musicnator.dto.CategoryDto;
import com.krushjanovski.musicnator.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryDto map(Category category);

}
