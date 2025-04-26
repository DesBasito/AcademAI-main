package com.academai.academai.repository;

import com.academai.academai.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findEnrollmentByCourseIdAndUserId(Long courseId, Long userId);
}
