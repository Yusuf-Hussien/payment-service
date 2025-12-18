package phi.paymentservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.Status;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
public class PaymentResponse {
    private long id;
    private long order_id;
    private long user_id;
    private BigDecimal amount;
    private Status status;
    private Currency currency;
}
