package phi.paymentservice.unit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import phi.paymentservice.repository.PaymentRepository;
import phi.paymentservice.service.IPaymentService;
import phi.paymentservice.service.PaymentService;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @InjectMocks
    private IPaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void processPayment() {
    }

    @Test
    void updateOrderStatusWithSuccess() {
    }

    @Test
    void updateOrderStatusWithFailed() {
    }
}