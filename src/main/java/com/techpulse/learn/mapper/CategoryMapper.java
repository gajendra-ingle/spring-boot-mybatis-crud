package com.techpulse.learn.mapper;

import com.techpulse.learn.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    Category findById(Long id);

    List<Category> findAll();

    void insertCategory(Category category);

    int deleteCategory(Long id);

    int updateCategory(Category category);


}
