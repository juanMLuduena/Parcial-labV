package com.utn.TP_Final.controller;

import com.utn.TP_Final.dto.ErrorResponseDto;
import com.utn.TP_Final.exceptions.ValidationException;
import com.utn.TP_Final.exceptions.WrongPrefixException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto validationExceptionHandler(ValidationException e){
        return new ErrorResponseDto(e.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto dataAccessExceptionHandler(DataAccessException e){
        return new ErrorResponseDto(e.getMessage());
    }

    @ExceptionHandler(WrongPrefixException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorResponseDto wrongPrefixExceptionHandler(WrongPrefixException e){
        return new ErrorResponseDto(e.getMessage());
    }

}
