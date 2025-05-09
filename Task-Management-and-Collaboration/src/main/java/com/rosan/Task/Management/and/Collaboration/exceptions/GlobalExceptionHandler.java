package com.rosan.Task.Management.and.Collaboration.exceptions;

import com.rosan.Task.Management.and.Collaboration.data.entities.ApiError;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DataRetrievalFailureException.class)
    public ResponseEntity<ApiError> handleUserRetrival(DataRetrievalFailureException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError(500,ex.getMessage(), new Date()));
    }

    @ExceptionHandler(value = ErrorWhileCreatingEntity.class)
    public ResponseEntity<ApiError> handleCreationError(ErrorWhileCreatingEntity ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400,ex.getMessage(), new Date()));
    }
    @ExceptionHandler(value = EmailAlreadyExist.class)
    public ResponseEntity<ApiError> handleEmailAlreadyExist(EmailAlreadyExist ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400, ex.getMessage(), new Date()));
    }
    @ExceptionHandler(value = AllFieldsRequiered.class)
    public ResponseEntity<ApiError> handleAllFieldsRequiered(AllFieldsRequiered ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400, ex.getMessage(), new Date()));
    }
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(404, ex.getMessage(), new Date()));
    }
}
