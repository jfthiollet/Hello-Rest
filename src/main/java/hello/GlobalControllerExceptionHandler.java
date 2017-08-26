package hello;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ErrorInfo> handleBadRequest(HttpServletRequest req,
			Exception ex) throws UnsupportedEncodingException {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Allow", "GET");
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.METHOD_NOT_ALLOWED,
				req.getRequestURI(), ex);
		return new ResponseEntity<ErrorInfo>(errorInfo, responseHeaders,
				HttpStatus.METHOD_NOT_ALLOWED);
	}
}