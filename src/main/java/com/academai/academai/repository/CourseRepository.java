package com.academai.academai.repository;

import com.academai.academai.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategoryIdIn(List<Long> categoryIds);
}
