package phi.paymentservice.unit.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phi.paymentservice.dto.PaymentRequest;
import phi.paymentservice.dto.PaymentResponse;
import phi.paymentservice.mappers.PaymentMapper;
import phi.paymentservice.model.Payment;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.PaymentMethod;
import phi.paymentservice.model.enums.Status;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMapperTest {

    PaymentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PaymentMapper();
    }

    @Test
    void toEntity_shouldMapDtoToEntity() {
        // Given
        PaymentRequest dto = PaymentRequest.builder()
                .amount(BigDecimal.valueOf(250.55))
                .currency(Currency.EGP)
                .payment_method(PaymentMethod.CARD)
                .order_id(55)
                .user_id(101)
                .build();

        // When
        Payment entity = mapper.toEntity(dto);

        // Then
        assertNotNull(entity);
        assertEquals(dto.getAmount(), entity.getAmount());
        assertEquals(dto.getCurrency(), entity.getCurrency());
        assertEquals(dto.getPayment_method(), entity.getPayment_method());
        assertEquals(dto.getOrder_id(), entity.getOrder_id());
        assertEquals(dto.getUser_id(), entity.getUser_id());
    }

    @Test
    void toDto_shouldMapEntityToDto() {

        //Given
        Payment entity = Payment.builder()
                .amount(BigDecimal.valueOf(250.88))
                .currency(Currency.EGP)
                .status(Status.APPROVED)
                .order_id(55)
                .user_id(101)
                .build();

        //When
        PaymentResponse dto = mapper.toDto(entity);

        //Then
        assertNotNull(entity);
        assertEquals(dto.getAmount(), entity.getAmount());
        assertEquals(dto.getCurrency(), entity.getCurrency());
        assertEquals(dto.getStatus(), entity.getStatus());
        assertEquals(dto.getOrder_id(), entity.getOrder_id());
        assertEquals(dto.getUser_id(), entity.getUser_id());
    }
}