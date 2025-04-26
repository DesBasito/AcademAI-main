package com.academai.academai.error.handler;

import com.academai.academai.error.ErrorResponseBody;
import com.academai.academai.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final ErrorService errorService;

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseBody> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(errorService.makeResponse(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseBody> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(errorService.makeResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseBody> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(errorService.makeResponse(e.getBindingResult()), HttpStatus.BAD_REQUEST);
    }
}
