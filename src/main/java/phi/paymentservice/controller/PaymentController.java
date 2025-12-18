package phi.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import phi.paymentservice.dto.PaymentRequest;
import phi.paymentservice.dto.PaymentResponse;
import phi.paymentservice.model.Payment;
import phi.paymentservice.service.IPaymentService;
import phi.paymentservice.mappers.PaymentMapper;

import java.math.BigDecimal;

@RestController
@RequestMapping("payments")
//@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentMapper paymentMapper, IPaymentService paymentService) {
        this.paymentMapper = paymentMapper;
        this.paymentService = paymentService;
    }

    @PostMapping("/create-payment-url")
    public PaymentResponse createPaymentToken(@RequestBody PaymentRequest paymentRequest) {

        Payment payment = paymentService.processPayment(
                paymentRequest.getOrder_id(),
                paymentRequest.getUser_id(),
                paymentRequest.getAmount()
        );

        PaymentResponse paymentResponse = paymentMapper.toDto(payment);
        String redirectUrl = "https://accept.paymob.com/unifiedcheckout/?publicKey={publicKey}&clientSecret={clientSecret}"
                .formatted();


        return paymentResponse;
    }


    @GetMapping("/callback")
    public PaymentResponse callback(@RequestParam long orderId,@RequestParam long amount) {
        Payment payment = paymentService.processPayment(orderId, 1L, BigDecimal.valueOf(amount));
        PaymentResponse paymentResponse = paymentMapper.toDto(payment);
        return paymentResponse;
    }

    @PostMapping("/server-callback")
    public PaymentResponse serverCallback(@RequestParam long orderId,@RequestParam long amount) {
        return null;
    }
}
