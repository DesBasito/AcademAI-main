package com.academai.academai.service;

import com.academai.academai.dto.user.UserDto;
import com.academai.academai.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    boolean checkIfUserExistsByEmail(String email);

    User getUserById(Long userId);

    UserDto getUserDtoById(Long userId);

    User getUserByEmail(String login);

    List<UserDto> getAllUsers();

    String uploadAvatar(Long userId, MultipartFile file);

    User getAuthenticatedUser();

    UserDto convertToUserDto(User user);
}
