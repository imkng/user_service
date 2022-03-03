package com.multiclient.userservice.exceptionhandler;

import com.multiclient.userservice.exception.CustomerNotFoundException;
import com.multiclient.userservice.exception.EmailAlreadyExistException;
import com.multiclient.userservice.exception.EmailIdFormatException;
import com.multiclient.userservice.exception.PasswordNotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistException(EmailAlreadyExistException exception) {
        return new ResponseEntity<>(Constants.EMAIL_ID_ALREADY_EXIST, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<Object> handlePasswordNotMatchException(PasswordNotMatchException exception) {
        return new ResponseEntity<>(Constants.PASSWORD_NOT_MATCH, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailIdFormatException.class)
    public ResponseEntity<Object> handleEmailIdFormatException(EmailIdFormatException exception) {
        return new ResponseEntity<>(Constants.EMAIL_ID_FORMAT_NOT_CORRECT, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return new ResponseEntity<>(Constants.CUSTOMER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
