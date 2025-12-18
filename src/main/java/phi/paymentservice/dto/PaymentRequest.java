package phi.paymentservice.dto;

import lombok.*;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.PaymentMethod;
import phi.paymentservice.model.enums.Status;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PaymentRequest {
    private long id;
    private long order_id;
    private long user_id;
    private PaymentMethod payment_method;
    private BigDecimal amount;
    private Currency currency;
}
