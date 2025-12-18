package phi.paymentservice.mappers;

import org.springframework.stereotype.Component;
import phi.paymentservice.dto.PaymentRequest;
import phi.paymentservice.dto.PaymentResponse;
import phi.paymentservice.model.Payment;

@Component
public class PaymentMapper implements IMapper<Payment, PaymentRequest,PaymentResponse> {

    @Override
    public Payment toEntity(PaymentRequest dto) {

        if(dto==null)return null;

        return Payment.builder()
                .amount(dto.getAmount())
                .currency(dto.getCurrency())
                .payment_method(dto.getPayment_method())
                .order_id(dto.getOrder_id())
                .user_id(dto.getUser_id())
                .build();
    }

    @Override
    public PaymentResponse toDto(Payment entity) {

        if(entity==null)return null;

        return PaymentResponse.builder()
                .amount(entity.getAmount())
                .currency(entity.getCurrency())
                .status(entity.getStatus())
                .order_id(entity.getOrder_id())
                .user_id(entity.getUser_id())
                .build();
    }

}
