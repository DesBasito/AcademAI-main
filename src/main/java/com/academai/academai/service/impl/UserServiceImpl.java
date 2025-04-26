package com.academai.academai.service.impl;

import com.academai.academai.dto.user.UserDto;
import com.academai.academai.entity.User;
import com.academai.academai.repository.UserRepository;
import com.academai.academai.service.interfaces.UserService;
import com.academai.academai.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public boolean checkIfUserExistsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public UserDto getUserDtoById(Long userId){
        User user = getUserById(userId);
        return convertToUserDto(user);
    }

    @Override
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User not found"));
    }


    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDto)
                .toList();
    }

    @Override
    public String uploadAvatar(Long userId, MultipartFile file){
        User user = getUserById(userId);
        if(user.isEnabled()){
            String fileName = FileUtils.uploadFile(file);
            user.setAvatar(fileName);
            log.info("Upload avatar successful");
            userRepository.save(user);
            return fileName;
        } else {
            throw new IllegalArgumentException("Удаленного пользователя нельзя редактировать");

        }
    }

    @Override
    public User getAuthenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getUserByEmail(authentication.getName());
    }

    @Override
    public UserDto convertToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    public String activateUser(String code) {
        User user = userRepository.findByActivationCode(code).orElse(null);
        if (user != null) {
            user.setEnabled(true);
            user.setActivationCode(null);
            userRepository.save(user);
            return "User activated successfully!";
        }
        return "Activation code is invalid!";
    }
}
