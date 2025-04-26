package com.academai.academai.dto.user;

import com.academai.academai.validation.PasswordMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private boolean isStudent;
}
