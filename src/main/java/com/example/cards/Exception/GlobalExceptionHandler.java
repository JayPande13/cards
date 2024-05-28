package com.example.cards.Exception;

import com.example.cards.Dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String,String> validationErrorMap = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
        validationErrorList.forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            String errorFieldName = ((FieldError) error).getField();
            validationErrorMap.put(errorFieldName, errorMessage);
        });

        return new ResponseEntity<>(validationErrorMap,HttpStatus.BAD_REQUEST);
    }

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
