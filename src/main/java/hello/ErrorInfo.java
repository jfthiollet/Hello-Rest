package hello;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
	public final int status;
	public final String error;
    public final String message;
    public final String path;


    public ErrorInfo(HttpStatus httpStatus, String path, Exception ex) {
    	this.status = Integer.parseInt(httpStatus.toString());
    	this.error = HttpStatus.valueOf(httpStatus.value()).getReasonPhrase();
        this.message = ex.getLocalizedMessage();
        this.path = path;
    }
}