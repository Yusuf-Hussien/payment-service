package phi.paymentservice.paymob;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import phi.paymentservice.paymob.dto.PaymobInitKeyRequest;
import phi.paymentservice.paymob.dto.PaymobInitKeyResponse;

@HttpExchange( url = "https://accept.paymob.com", accept = "application/json")
public interface PaymobService {

    @PostExchange(value = "/v1/intention/", contentType = "application/json")
    PaymobInitKeyResponse initClientKey(
            @RequestHeader("Authorization")String auth,
            @RequestBody PaymobInitKeyRequest body
    );

}
