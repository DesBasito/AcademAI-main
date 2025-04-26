package com.academai.academai.controller;

import com.academai.academai.dto.user.UserDto;
import com.academai.academai.service.EnrollmentService;
import com.academai.academai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{courseId}")
    public ResponseEntity<List<UserDto>> getUsersByCourseId(@PathVariable("courseId") Long courseId) {
        List<UserDto> users = enrollmentService.getUsersByCourseId(courseId);
        if(users.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        UserDto user = userService.getUserDtoById(userId);
        return ResponseEntity.ok(user);
    }

}
