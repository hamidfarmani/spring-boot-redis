package com.hamid.redis.exception;

import com.hamid.redis.questionnaire.QuestionnaireNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  static Logger LOGGER = LogManager.getLogger(ApiExceptionHandler.class);


  @ExceptionHandler(value = {QuestionnaireNotFoundException.class})
  public ResponseEntity<Object> handleQuestionnaireNotFoundException(
      QuestionnaireNotFoundException e) {
    HttpStatus notFound = HttpStatus.NOT_FOUND;
    ApiException apiException =
        new ApiException(e.getMessage(), notFound, ZonedDateTime.now(ZoneId.of("Z")));
    LOGGER.error(e.getMessage());
    return new ResponseEntity<>(apiException, notFound);
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    Map<String, String> errors = new HashMap<>();
    e.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    ApiException apiException =
        new ApiException(errors.toString(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
    LOGGER.error(errors.toString());
    return new ResponseEntity(apiException, badRequest);
  }

  @ExceptionHandler(value = {AccessDeniedException.class})
  public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException e) {
    HttpStatus forbidden = HttpStatus.FORBIDDEN;
    ApiException apiException =
        new ApiException(e.getMessage(), forbidden, ZonedDateTime.now(ZoneId.of("Z")));
    LOGGER.error(e.getMessage());
    return new ResponseEntity<>(apiException, forbidden);
  }
}
