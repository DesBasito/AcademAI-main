package com.academai.academai.service.interfaces;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.entity.Course;

import java.util.List;

public interface CourseService {
//    List<CourseDto> getAllCoursesDto();

    List<CourseDto> getAllCoursesDto();

    CourseDto getCourseDtoById(Long id);

    Course getCourseById(Long id);


    List<CourseDto> getCoursesByCategoryAndSubcategories(Long categoryId);

    List<CourseDto> convertToListCourseDto(List<Course> courses);

    CourseDto convertToCourseDto(Course course);

//    void enrollCourse(Long courseId, String login);
//
//    void unenrollCourse(Long courseId, String login);
//
//    List<CourseDto> getCoursesByUserId(Long userId);
//
//    CourseDto convertToCourseDto(Course course);
}
