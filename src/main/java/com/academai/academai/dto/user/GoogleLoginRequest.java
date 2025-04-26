package com.academai.academai.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoogleLoginRequest {
    @NotBlank
    private String idToken;
    @NotBlank
    private String fingerprint;
}
