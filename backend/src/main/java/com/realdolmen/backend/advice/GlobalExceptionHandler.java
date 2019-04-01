package com.realdolmen.backend.advice;

import com.realdolmen.backend.dto.ErrorDto;
import com.realdolmen.backend.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class
    })
    public ResponseEntity<ErrorDto> methodArgumentNotValidException(Exception ex) {
        List<FieldError> fieldErrors;
        if (ex
                instanceof BindException) {
            fieldErrors = ((BindException) ex).getFieldErrors();
        } else {
            fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        }

        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.BAD_REQUEST)
                .messages(
                        fieldErrors.stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.toList())
                )
                .build();

        log.error(errorDto.toString());

        return ResponseEntity.badRequest()
                .body(errorDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(NotFoundException nfe) {
        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Not found")
                .build();

        log.error(errorDto.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> exception(Exception ex) {
        ErrorDto errorDto = ErrorDto.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("A shiny pink elephant went missing")
                .build();

        log.error(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDto);
    }
}
