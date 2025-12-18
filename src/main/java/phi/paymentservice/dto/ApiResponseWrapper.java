package phi.paymentservice.dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
//@Schema(description = "Generic API response wrapper containing success status, data payload, and error message if it exists")
public class ApiResponseWrapper <D>{

    private boolean success;
    private String message;
    private D data;

    public static <D> ApiResponseWrapper<D> success(D data){
        return ApiResponseWrapper.<D>builder()
                .success(true)
                .data(data)
                .message("SUCCESS")
                .build();
    }

    public static <D> ApiResponseWrapper<D> error(String message){
        return ApiResponseWrapper.<D>builder()
                .success(false)
                .data(null)
                .message(message)
                .build();
    }
}
