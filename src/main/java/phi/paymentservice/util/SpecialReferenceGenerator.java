package phi.paymentservice.util;

import phi.paymentservice.model.enums.PaymentMethod;

import java.util.UUID;

public class SpecialReferenceGenerator {

    public static String generateReference(PaymentMethod type) {
        return String.format("%s-%s-%d",
                type.toString(),
                UUID.randomUUID().toString().substring(0, 8),
                System.currentTimeMillis());
    }

}
