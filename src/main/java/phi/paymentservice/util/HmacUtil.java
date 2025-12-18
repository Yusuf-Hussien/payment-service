package phi.paymentservice.util;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HexFormat;

@Component
@Setter
public class HmacUtil {

    @Value("${paymob.hmac.secret}")
    private String SECRET;

    @Value("${paymob.hmac.algorithm:HmacSHA512}")
    private String HMAC_ALGORITHM;

    public boolean verifyHmac(String providedHmac, String data) {
        String generatedHmac = generateHmac(data);
        return generatedHmac.equals(providedHmac);
    }

    public String generateHmac(String data){
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec keySpec =  new SecretKeySpec(SECRET.getBytes(), HMAC_ALGORITHM);
            mac.init(keySpec);
            byte[] rawHmac =  mac.doFinal(data.getBytes());
            return HexFormat.of().formatHex(rawHmac);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("FAILED TO SET HMAC ALGORITHM: \n", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("FAILED TO SET THE SECRET KEY:\n",e);
        }
    }

}
