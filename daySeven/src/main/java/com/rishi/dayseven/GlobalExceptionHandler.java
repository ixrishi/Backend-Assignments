package com.rishi.dayseven;

import com.rishi.dayseven.customExceptions.AppException;
import com.rishi.dayseven.customExceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {
//        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> errorMap =new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(
                error -> {
                    String fieldName =((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    errorMap.put(fieldName,message);
                }
        );
        return  errorMap;
    }

    @ExceptionHandler(AppException.class)
    public  ResponseEntity<?> handleAppException( String msg , HttpStatus statusCode){
        return buildResponse(msg,statusCode);
    }


    public  ResponseEntity<?>  buildResponse (String msg, HttpStatus statusCode){
        return new ResponseEntity<>(
                Map.of(
                        "timestamp", LocalDateTime.now(),
                        "status",statusCode.value(),
                        "error",msg

                ),
                statusCode
        );
    }

}
