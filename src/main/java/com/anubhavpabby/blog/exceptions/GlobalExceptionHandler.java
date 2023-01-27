package com.anubhavpabby.blog.exceptions;

import com.anubhavpabby.blog.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        String message = exception.getMessage();
//        String localizedMessage = exception.getLocalizedMessage();

        return new ResponseEntity<ApiResponse>(new ApiResponse(
                message,
                false
        ), HttpStatus.NOT_FOUND);
    }
}
