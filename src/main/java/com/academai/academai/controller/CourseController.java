package com.academai.academai.controller;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.service.interfaces.CourseService;
import com.academai.academai.service.interfaces.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
