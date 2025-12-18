package phi.paymentservice.unit.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import phi.paymentservice.util.HmacUtil;

import static org.junit.jupiter.api.Assertions.*;

class HmacUtilTest {

    private static final String SECRET = "test_secret";
    private static final String DATA = "sample_data";
    HmacUtil hmacUtil;

    @BeforeEach
    void setUp() {
        hmacUtil = new HmacUtil();
        ReflectionTestUtils.setField(hmacUtil, "HMAC_ALGORITHM", "HmacSHA512");
        ReflectionTestUtils.setField(hmacUtil, "SECRET", SECRET );
    }

    @Test
    void generateHmac_shouldReturnValidBase64String() {
        String hmac = hmacUtil.generateHmac(DATA);

        assertNotNull(hmac);
        assertFalse(hmac.isEmpty());

        // Check if it's valid Base64
        assertDoesNotThrow(() -> java.util.Base64.getDecoder().decode(hmac));
    }

    @Test
    void isHmacValid_shouldReturnTrueForMatchingHmac() {
        String generatedHmac = hmacUtil.generateHmac(DATA);

        boolean isValid = hmacUtil.verifyHmac(generatedHmac, DATA);

        assertTrue(isValid, "Expected HMAC to be valid for matching data and secret");
    }

    @Test
    void isHmacValid_shouldReturnTrueForMatchingPreCalculatedHmac() {
        String receivedHmac = "75054f0ca41b503aae4d0e1072c394b4b5a842260bb04af75fd9935e38c59419b313b64ca59e3ed627588e24c42893bb2f028d4b9ea8f712bf7357f4576a7aaf";
        String generatedHmac = hmacUtil.generateHmac(DATA);

        assertEquals(receivedHmac, generatedHmac);
    }

    @Test
    void isHmacValid_shouldReturnFalseForDifferentData() {
        String generatedHmac = hmacUtil.generateHmac(DATA);

        boolean isValid = hmacUtil.verifyHmac(generatedHmac, "different_data");

        assertFalse(isValid, "Expected HMAC to be invalid for different data");
    }

    @Test
    void isHmacValid_shouldReturnFalseForDifferentSecret() {
        String generatedHmac = hmacUtil.generateHmac(DATA);

        hmacUtil.setSECRET("wrong_secret");
        boolean isValid = hmacUtil.verifyHmac(generatedHmac, DATA);

        assertFalse(isValid, "Expected HMAC to be invalid for different secret");
    }
}