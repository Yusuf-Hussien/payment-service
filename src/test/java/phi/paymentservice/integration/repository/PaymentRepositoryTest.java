package phi.paymentservice.integration.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import phi.paymentservice.model.Payment;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.PaymentMethod;
import phi.paymentservice.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository.deleteAll();

        Payment payment = Payment.builder()
                .amount(BigDecimal.valueOf(199))
                .currency(Currency.EGP)
                .payment_method(PaymentMethod.CARD)
                .build();

        paymentRepository.save(payment);
    }

    @Test
    void findAll_ShouldReturnAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        assertTrue(payments.size() > 0);

        assertEquals(payments.get(0).getPayment_id(),1);
        assertTrue(payments.get(0).getAmount().compareTo(BigDecimal.valueOf(199)) == 0);
        assertTrue(payments.get(0).getCurrency().equals(Currency.EGP));
        assertTrue(payments.get(0).getPayment_method().equals(PaymentMethod.CARD));

    }
}