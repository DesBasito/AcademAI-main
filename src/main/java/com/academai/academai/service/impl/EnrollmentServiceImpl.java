package com.academai.academai.service.impl;

import com.academai.academai.dto.CourseDto;
import com.academai.academai.dto.user.UserDto;
import com.academai.academai.entity.Course;
import com.academai.academai.entity.Enrollment;
import com.academai.academai.entity.User;
import com.academai.academai.repository.EnrollmentRepository;
import com.academai.academai.service.interfaces.CourseService;
import com.academai.academai.service.interfaces.EnrollmentService;
import com.academai.academai.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseService courseService;
    private final UserService userService;

    @Override
    public void createEnrollment(Long courseId) {
        User user = userService.getAuthenticatedUser();
        Course course = courseService.getCourseById(courseId);
        Optional<Enrollment> existingEnrollment = findByCourseIdAndUserId(courseId, user.getId());

        if (existingEnrollment.isPresent()) {
            Enrollment enrollment = existingEnrollment.get();
            enrollment.setActive(true);
            enrollment.setEnrollmentDate(LocalDateTime.now());
            enrollment.setUnenrollmentDate(null);
            enrollmentRepository.save(enrollment);
        } else {
            Enrollment newEnrollment = new Enrollment();
            newEnrollment.setCourse(course);
            newEnrollment.setUser(user);
            newEnrollment.setEnrollmentDate(LocalDateTime.now());
            newEnrollment.setActive(true);
            enrollmentRepository.save(newEnrollment);
        }

    }

    @Override
    public void deleteEnrollment(Long courseId){
        User user = userService.getAuthenticatedUser();
        Optional<Enrollment> enrollment = findByCourseIdAndUserId(courseId, user.getId());
        if (enrollment.isEmpty()) {
            throw new NoSuchElementException("Enrollment not found for courseId " + courseId + " and email " + user.getEmail());
        }
        Enrollment enrollmentEntity = enrollment.get();
        enrollmentEntity.setActive(false);
        enrollmentEntity.setUnenrollmentDate(LocalDateTime.now());
        enrollmentRepository.save(enrollmentEntity);

    }


    @Override
    public List<CourseDto> getCoursesByUserId(Long userId){
        User user = userService.getUserById(userId);
        return user.getEnrollments().stream()
                .map(enrollment -> courseService.convertToCourseDto(enrollment.getCourse()))
                .toList();
    }

    @Override
    public List<UserDto> getUsersByCourseId(Long courseId){
        Course course = courseService.getCourseById(courseId);
        return course.getEnrollments().stream()
                .map(enrollment -> userService.convertToUserDto(enrollment.getUser()))
                .toList();
    }

    private Optional<Enrollment> findByCourseIdAndUserId(Long courseId, Long userId){
        return enrollmentRepository.findEnrollmentByCourseIdAndUserId(courseId, userId);
    }
}
