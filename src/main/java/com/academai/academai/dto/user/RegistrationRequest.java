package com.academai.academai.dto.user;

import com.academai.academai.validation.PasswordMatch;
import com.academai.academai.validation.UniqueEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatch
public class RegistrationRequest {
    @NotBlank(message = "Заполните имя")
    private String name;
    private String surname;
    @NotBlank(message = "Заполните имя")
    @UniqueEmail
    private String email;
    @NotBlank(message = "Заполните пароль")
    @Size(min = 4, max = 20,
            message = "Длина пароля должна быть не меньше 4 и не больше 20 символов")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Пароль должен содержать как минимум одну заглавную букву и одну цифру")
    private String password;
    @NotBlank(message = "Подтвердите пароль")
    private String confirmPassword;
    @NotNull(message = "Заполните роль")
    private Boolean isStudent;
}
