package course.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ExistEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;

    private final String errorCode;

	public ExistEmailException(HttpStatus httpStatus, String errorCode, String errorMessage) {
		super(errorMessage);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}
}
