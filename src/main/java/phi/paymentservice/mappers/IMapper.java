package phi.paymentservice.mappers;

import phi.paymentservice.dto.PaymentRequest;
import phi.paymentservice.dto.PaymentResponse;
import phi.paymentservice.model.Payment;

public interface IMapper<ENTITY,REQUEST_DTO,RESPONSE_DTO> {
    ENTITY toEntity(REQUEST_DTO dto);
    RESPONSE_DTO toDto(ENTITY entity);
}
