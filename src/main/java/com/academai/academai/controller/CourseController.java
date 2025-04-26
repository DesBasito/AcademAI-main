package com.academai.academai.controller;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.dto.MaterialDto;
import com.academai.academai.entity.Material;
import com.academai.academai.service.CourseService;
import com.academai.academai.service.EnrollmentService;
import com.academai.academai.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAllCoursesDto();
        if(courses.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("courseId") Long courseId) {
        CourseDto course = courseService.getCourseDtoById(courseId);
        if(course == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course);
    }

    @GetMapping("by-user/{userId}")
    public ResponseEntity<List<CourseDto>> getCoursesByUserId(@PathVariable Long userId){
        List<CourseDto> courses = enrollmentService.getCoursesByUserId(userId);
        if(courses.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("join/{courseId}")
    public ResponseEntity<?> joinCourse(@PathVariable Long courseId) {
        try {
            enrollmentService.createEnrollment(courseId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("leave/{courseId}")
    public ResponseEntity<?> leaveCourse(@PathVariable Long courseId) {
        try {
            enrollmentService.deleteEnrollment(courseId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("by-category/{categoryId}")
    public ResponseEntity<List<CourseDto>> getCoursesByCategoryId(@PathVariable Long categoryId) {
        List<CourseDto> courses = courseService.getCoursesByCategoryAndSubcategories(categoryId);
        if(courses.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courses);
    }

}
