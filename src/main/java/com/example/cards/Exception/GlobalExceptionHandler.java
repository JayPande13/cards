package com.example.cards.Exception;

import com.example.cards.Dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> resourceMessageNotFoundHandler(ResourceNotFoundException exception, WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.NOT_FOUND,
                exception.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CardAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> cardAlreadyExistExceptionHandler(CardAlreadyExistsException exception, WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.BAD_REQUEST,
                exception.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> globalExceptionHandler(Exception exception, WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorResponseDto(webRequest.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
