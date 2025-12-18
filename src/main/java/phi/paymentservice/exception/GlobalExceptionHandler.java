package phi.paymentservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import phi.paymentservice.dto.ApiResponseWrapper;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class, Exception.class})
    public ApiResponseWrapper<?> handleRuntimeException(RuntimeException e) {
        return ApiResponseWrapper.error(e.getMessage());
    }
}
