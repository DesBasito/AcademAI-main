package com.academai.academai.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class AesPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return EncryptionUtil.encrypt(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(EncryptionUtil.decrypt(encodedPassword));
    }
}
