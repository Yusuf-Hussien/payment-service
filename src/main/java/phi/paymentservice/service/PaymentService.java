package phi.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import phi.paymentservice.model.Payment;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.Status;
import phi.paymentservice.repository.PaymentRepository;
import phi.paymentservice.util.HmacUtil;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService{

    private final PaymentRepository paymentRepository;
    private final HmacUtil hmacUtil;

    @Value("${paymob.API_KEY}")
    private String API_KEY;

    @Value("${paymob.PUBLIC_KEY}")
    private String PUBLIC_KEY;

    @Value("${paymob.SECRET_KEY}")
    private String SECRET_KEY;

    @Override
    public Payment processPayment(long order_id, long user_id, BigDecimal amount) {

//        var billingData = Map.of(
//                "apartment", "N/A",
//                "first_name", student.getFirstName() != null ? student.getFirstName() : "Guest",
//                "last_name", student.getLastName() != null ? student.getLastName() : "User",
//                "street", "N/A",
//                "building", "N/A",
//                "phone_number", student.getPhoneNumber(),
//                "country", student.getCountry(),
//                "email", student.getEmail(),
//                "floor", "N/A",
//                "state", "N/A",
//                "city", "N/A"
//        );



        return paymentRepository.save(Payment.builder()
                .amount(amount)
                .currency(Currency.EGP)
                .order_id(order_id)
                .build());
    }

    @Override
    public Payment updateOrderStatusWithSuccess(long payment_id) {
        return updateOrderStatus(payment_id, Status.APPROVED);
    }

    @Override
    public Payment updateOrderStatusWithFailed(long payment_id) {
        return updateOrderStatus(payment_id, Status.FAILED);
    }


    private Payment updateOrderStatus(long payment_id,Status status) {
        Optional<Payment> payment = paymentRepository.getById(payment_id);
        if (payment.isEmpty()) {
            throw new RuntimeException("Payment with id %s not found".formatted(payment_id));
        }
        payment.get().setStatus(status);

        return payment.get();
    }
}
