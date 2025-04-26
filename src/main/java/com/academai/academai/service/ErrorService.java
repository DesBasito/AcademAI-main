package com.academai.academai.service;

import com.academai.academai.error.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(Exception exception);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
