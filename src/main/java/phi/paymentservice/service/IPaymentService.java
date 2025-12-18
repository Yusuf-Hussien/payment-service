package phi.paymentservice.service;

import phi.paymentservice.dto.PaymentResponse;
import phi.paymentservice.model.Payment;

import java.math.BigDecimal;

public interface IPaymentService {

    Payment processPayment(long order_id, long user_id, BigDecimal amount);
    Payment updateOrderStatusWithSuccess(long payment_id);
    Payment updateOrderStatusWithFailed(long payment_id);
}
