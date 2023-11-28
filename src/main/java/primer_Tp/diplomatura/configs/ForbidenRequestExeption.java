package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class ForbidenRequestExeption extends RuntimeException {
    private HttpStatus status;
    
    public ForbidenRequestExeption(String message) {
        super(message);
        this.status = HttpStatus.FORBIDDEN;
    }

    public ForbidenRequestExeption(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.FORBIDDEN;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    
}
