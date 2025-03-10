package ru.kopr.demokoprapi2.errors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kopr.demokoprapi2.dto.response.CustomSuccessResponse;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Перехват собственных исключений
    @ExceptionHandler(CustomException.class)
    ResponseEntity<CustomSuccessResponse<Integer>> handleCustomException(CustomException e) {
        List<Integer> errorCodes = List.of(e.getErrorCodes().getErrorCode());
        List<String> errorMessages = List.of(e.getErrorCodes().getErrorMessage());

        return ResponseEntity
                .badRequest()
                .body(new CustomSuccessResponse<>(
                        errorCodes.get(0),
                        errorCodes,
                        errorMessages,
                        false)
                );
    }

    // Перехват исключений валидации
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<CustomSuccessResponse<Integer>> handleConstraintViolationException(ConstraintViolationException e) {
        // Лист кодов ошибок
        List<Integer> violationErrorCodes = e.getConstraintViolations()
                .stream()
                .map(objectError -> ErrorCodes.getErrorCodeByMessage(objectError.getMessage()))
                .toList();

        // Лист сообщений ошибок
        List<String> violationErrorMessages = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        return ResponseEntity.badRequest()
                .header(HttpStatus.BAD_REQUEST.toString(), e.getMessage())
                .body(new CustomSuccessResponse<>(
                        violationErrorCodes.get(0),
                        violationErrorCodes,
                        violationErrorMessages,
                        false
                ));
    }

    // Перехват исключений валидации
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<CustomSuccessResponse<Integer>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // Лист кодов ошибок
        List<Integer> validationErrorsCodes = e.getBindingResult().getAllErrors().stream()
                .map(objectError -> ErrorCodes.getErrorCodeByMessage(objectError.getDefaultMessage()))
                .toList();

        // Лист сообщений ошибок
        List<String> validationErrorsMessages = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .toList();

        return ResponseEntity.badRequest()
                .header(HttpStatus.BAD_REQUEST.toString(), e.getMessage())
                .body(new CustomSuccessResponse<>(
                        validationErrorsCodes.get(0),
                        validationErrorsCodes,
                        validationErrorsMessages,
                        false
                ));
    }
}
