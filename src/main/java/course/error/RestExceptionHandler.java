package course.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import course.exception.ExistEmailException;
import course.exception.UnsupportedUserException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<ApiError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    	List<ApiError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
        	String[] messageCode = error.getDefaultMessage().split(":");
        	String errorCode = messageCode[0];
        	String message = messageCode[1];
        	errors.add(new ApiError(errorCode, message));
        });
        log.debug("Status Error: {}, Message: {}", HttpStatus.BAD_REQUEST, errors.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({UnsupportedUserException.class})
    public ResponseEntity<ApiError> handleUnsupportedUserException(UnsupportedUserException ex) {
    	ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
    	log.debug("Status Error: {}, Message: {}", ex.getHttpStatus(), ex.getMessage());
    	return buildResponseEntity(apiError, ex.getHttpStatus());
    }

	@ExceptionHandler({ExistEmailException.class})
    public ResponseEntity<ApiError> handleExistEmailException(ExistEmailException ex) {
    	ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
    	log.debug("Status Error: {}, Message: {}", ex.getHttpStatus(), ex.getMessage());
    	return buildResponseEntity(apiError, ex.getHttpStatus());
    }
    
    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError, HttpStatus httpStatus) {
		return new ResponseEntity<>(apiError, httpStatus);
	}    
}
