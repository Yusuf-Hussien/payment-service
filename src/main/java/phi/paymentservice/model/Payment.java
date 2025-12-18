package phi.paymentservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import phi.paymentservice.model.enums.Currency;
import phi.paymentservice.model.enums.PaymentMethod;
import phi.paymentservice.model.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;

    private long order_id;
    private long user_id;

    @Column(precision = 8, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime created_at;
    
    @LastModifiedDate
    private LocalDateTime updated_at;
}
