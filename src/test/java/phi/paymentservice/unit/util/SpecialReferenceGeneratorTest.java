package phi.paymentservice.unit.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phi.paymentservice.model.enums.PaymentMethod;
import phi.paymentservice.util.SpecialReferenceGenerator;

import static org.junit.jupiter.api.Assertions.*;

class SpecialReferenceGeneratorTest {

    @Test
    void Should_generate_special_reference() {
        String ref = SpecialReferenceGenerator.generateReference(PaymentMethod.CARD);

        assertNotNull(ref);
        assertFalse(ref.isBlank());

        String[] parts = ref.split("-");

        assertEquals(3, parts.length, "Reference should contain 3 parts separated by '-'");

        assertEquals("CARD", parts[0]);

        assertEquals(8, parts[1].length(), "UUID part must be 8 characters");

        assertDoesNotThrow(() -> Long.parseLong(parts[2]),
                "Last part should be a valid timestamp (long)");
    }
}