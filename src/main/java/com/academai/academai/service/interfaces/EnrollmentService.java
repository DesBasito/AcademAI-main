package com.academai.academai.service.interfaces;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.dto.user.UserDto;

import java.util.List;

public interface EnrollmentService {
    void createEnrollment(Long courseId);

    void deleteEnrollment(Long courseId);

    List<CourseDto> getCoursesByUserId(Long userId);

    List<UserDto> getUsersByCourseId(Long courseId);
}
