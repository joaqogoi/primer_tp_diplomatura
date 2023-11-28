package primer_Tp.diplomatura.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHandler {
    
    public static <T> ResponseEntity<Object> builderResponse(String title, HttpStatus status, T data, Throwable throwable){
        if(throwable != null) {
            ApiResponseThrowable apiResponseThrowable = new ApiResponseThrowable(title, throwable);
            return new ResponseEntity<>(apiResponseThrowable, apiResponseThrowable.getStatus());
        } else {
            ApiResponse<T> apiResponse = new ApiResponse<>();
            apiResponse.setMessage(title);
            apiResponse.setData(data);
            return new ResponseEntity<>(apiResponse, status);
        }
    }
}
