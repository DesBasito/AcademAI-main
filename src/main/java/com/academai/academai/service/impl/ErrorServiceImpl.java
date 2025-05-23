package com.academai.academai.service.impl;

import com.academai.academai.error.ErrorResponseBody;
import com.academai.academai.service.interfaces.ErrorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ErrorServiceImpl implements ErrorService {

    @Override
    public ErrorResponseBody makeResponse(Exception exception){
        String errorMessage = exception.getMessage();
        return ErrorResponseBody.builder()
                .error(errorMessage)
                .reasons(Map.of("errors", List.of(errorMessage)))
                .build();
    }

    @Override
    public ErrorResponseBody makeResponse(BindingResult bindingResult){
        Map<String, List<String>> reasons = new HashMap<>();
        bindingResult.getFieldErrors().stream()
                .filter(e -> e.getDefaultMessage() != null)
                .forEach(e -> {
                    List<String> errors = new ArrayList<>();
                    errors.add(e.getDefaultMessage());
                    if(!reasons.containsKey(e.getField())){
                        reasons.put(e.getField(), errors);
                    } else {
                        reasons.get(e.getField()).addAll(errors);
                    }
                });
        return ErrorResponseBody.builder()
                .error("Validation error")
                .reasons(reasons)
                .build();
    }
}
