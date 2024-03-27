package ErrorHandiling;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import PersonalizedDataAPIEntity.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex) {
//		// Log the exception
//		ex.printStackTrace();
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body("An unexpected error occurred. Please try again later.");
//	}

	@ExceptionHandler(ProductNotFoundException.class)
	protected ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex) {
		HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}

	@ExceptionHandler(InvalidIdException.class)
	protected ResponseEntity<Object> handleInvalidId(InvalidIdException ex) {
		HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleException(Exception ex) {
		HttpStatus httpStatus = HttpStatus.CONFLICT;
		String error = ex.getMessage();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", ex.getMessage());
		int statusCode = httpStatus.value();
		ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(), httpStatus.value(), error, httpStatus);
		return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).headers(headers).body(apiErrors);
	}

}
