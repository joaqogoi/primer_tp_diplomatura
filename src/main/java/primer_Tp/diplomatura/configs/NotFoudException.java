package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class NotFoudException extends RuntimeException {
    private HttpStatus status;
    
    public NotFoudException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
    }

    public NotFoudException(String message, Throwable cause){
        super(message, cause);
        this.status = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

