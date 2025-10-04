package com.Portfolio.app.Exception;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Portfolio.app.Exception.CustomException.AssetNotFoundException;
import com.Portfolio.app.Exception.CustomException.DashboardIdNotFoundException;
import com.Portfolio.app.Exception.CustomException.InsufficientBalanceException;
import com.Portfolio.app.Exception.CustomException.UserIdNotFoundException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<Map<String, Object>> UserNotFoundException(UserIdNotFoundException ux) {
        Map<String, Object> error = new HashMap<>();
        error.put("Error", "We can not Find the User Id In the Database!");
        error.put("Message", ux.getMessage());
        error.put("Status", HttpStatus.NOT_FOUND.value());
        // error.put("TimeStamp", LocalDateTime.now());
        error.put("TimeStamp", OffsetDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DashboardIdNotFoundException.class)
    public ResponseEntity<Map<String, Object>> DashboardIdNotFoundException(DashboardIdNotFoundException px) {
        Map<String, Object> err = new HashMap<>();
        err.put("Message", "ID NOT FOUND");
        err.put("Error", "Sorry ! We could not found the Dashboard id ");
        err.put("Status", HttpStatus.NOT_FOUND.value());
        // err.put("TimeStamp", LocalDateTime.now());
        err.put("TimeStamp", OffsetDateTime.now());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    // Handle Validation Exception...

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> ValidationException(MethodArgumentNotValidException ve) {
        Map<String, Object> err = new HashMap<>();
        String errMessage = ve.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + " : " + error.getDefaultMessage()).findFirst().orElse("Invalid Input");
        err.put("Message", "VALIDATION FAILED");
        err.put("Error", errMessage);
        err.put("Status", HttpStatus.UNAUTHORIZED.value());
        // err.put("TimeStamp", LocalDateTime.now());
        err.put("TimeStamp", OffsetDateTime.now());

        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> ViolationException(DataIntegrityViolationException deve) {
        Map<String, Object> er = new HashMap<>();

        er.put("Message", "Please Check Post Method, Might you are Trying to set null value");
        er.put("Error", "Data Integrity Voilation Exception Occured !");
        er.put("Status", HttpStatus.CONFLICT.value());
        er.put("TimeStamp", OffsetDateTime.now());

        return new ResponseEntity<>(er, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Map<String, Object>> InsufficientWalletBalanceException(Exception wex) {
        Map<String, Object> err = new HashMap<>();
        err.put("Message", "Insufficient Balance in your Wallet");
        err.put("Error", wex.getMessage());
        err.put("Status", HttpStatus.BAD_REQUEST.value());
        err.put("TimeStamp", OffsetDateTime.now());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Map<String, Object>> UserWalletNotFound(NullPointerException npx) {

        Map<String, Object> err = new HashMap<>();
        err.put("Message", "User Wallet Not Created yet");
        err.put("Error", npx.getMessage());
        err.put("Status", HttpStatus.NOT_FOUND.value());
        err.put("TimeStamp", OffsetDateTime.now());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(AssetNotFoundException.class)
    public ResponseEntity<Map<String, Object>> AssetNameNotFoundException(Exception e){
        Map<String, Object> ANF = new HashMap<>();
        ANF.put("Message", "We can Not Found the Asset Name Which you Given in Request!");
        ANF.put("Error", e.getMessage());
        ANF.put("Status", HttpStatus.NOT_FOUND.value());
        ANF.put("TimeStamp", OffsetDateTime.now());

        return new ResponseEntity<>(ANF, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> EvergreenExceptionHandler(Exception ex) {
        Map<String, Object> Allerr = new HashMap<>();

        Allerr.put("Message", "Service Down, Please Try Again!");
        Allerr.put("Error", "INTERNAL SERVER ERROR");
        Allerr.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        Allerr.put("TimeStamp", LocalDateTime.now());

        return new ResponseEntity<>(Allerr, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
