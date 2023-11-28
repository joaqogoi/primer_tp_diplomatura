package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    private HttpStatus status;
    
    public BadRequestException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
}
