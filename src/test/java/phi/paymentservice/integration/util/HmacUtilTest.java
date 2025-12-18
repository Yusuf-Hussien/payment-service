package phi.paymentservice.integration.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import phi.paymentservice.repository.PaymentRepository;
import phi.paymentservice.service.PaymentService;
import phi.paymentservice.util.HmacUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = HmacUtil.class)
public class HmacUtilTest {
    @Autowired
    private HmacUtil hmacUtil;

    private static final String DATA = "sample_data";

    @Test
    void isHmacValid_shouldReturnTrueForMatchingHmac() {
        String generatedHmac = hmacUtil.generateHmac(DATA);

        boolean isValid = hmacUtil.verifyHmac(generatedHmac, DATA);

        assertTrue(isValid, "Expected HMAC to be valid for matching data and secret");
    }
}
