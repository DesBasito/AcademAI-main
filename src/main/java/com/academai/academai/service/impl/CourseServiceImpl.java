package com.academai.academai.service.impl;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.entity.Category;
import com.academai.academai.entity.Course;
import com.academai.academai.repository.CourseRepository;
import com.academai.academai.service.CategoryService;
import com.academai.academai.service.CourseService;
import com.academai.academai.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModuleService moduleService;
    private final CategoryService categoryService;


    @Override
    public List<CourseDto> getAllCoursesDto(){
        return convertToListCourseDto(courseRepository.findAll());
    }


    @Override
    public CourseDto getCourseDtoById(Long id){
        return convertToCourseDto(getCourseById(id));
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Course not found"));
    }

    @Override
    public List<CourseDto> getCoursesByCategoryAndSubcategories(Long categoryId){
        Category category = categoryService.getCategoryById(categoryId);
        List<Long> categoryIds = categoryService.getAllCategoryIdsIncludingSubcategories(category);
        List<Course> courses = courseRepository.findByCategoryIdIn(categoryIds);
        return convertToListCourseDto(courses);
    }



    @Override
    public List<CourseDto> convertToListCourseDto(List<Course> courses){
        return courses.stream().map(this::convertToCourseDto).toList();
    }

    @Override
    public CourseDto convertToCourseDto(Course course){
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .image(course.getImage())
                .modules(moduleService.convertToListModuleDto(course.getModules()))
                .build();
    }

}
