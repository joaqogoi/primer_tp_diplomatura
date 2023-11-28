package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class ConflictException extends RuntimeException {
    private HttpStatus status;

    public ConflictException(String message) {
        super(message);
        this.status = HttpStatus.CONFLICT;
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.CONFLICT;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    
    
}
