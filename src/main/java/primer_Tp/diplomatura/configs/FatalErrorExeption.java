package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;

public class FatalErrorExeption extends RuntimeException {
    private HttpStatus status;
    
    public FatalErrorExeption(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public FatalErrorExeption(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    
}
