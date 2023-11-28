package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class ApiResponseThrowable {
    private String message;
    private Throwable throwable;
    private HttpStatus status;
    
    public ApiResponseThrowable(){}
    public ApiResponseThrowable(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Throwable getThrowable() {
        return throwable;
    }
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
       
}