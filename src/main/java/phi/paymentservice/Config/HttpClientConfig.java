package phi.paymentservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;
import phi.paymentservice.paymob.PaymobService;

@Configuration(proxyBeanMethods = false)
@ImportHttpServices(group = "paymob", basePackageClasses = PaymobService.class)
public class HttpClientConfig {

    @Bean
    RestClient restClient() {
        return RestClient.builder()
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (request, response) -> {
                    String errorBody = new String(response.getBody().readAllBytes());
                    throw new RuntimeException("Client error " + response.getStatusCode() + ": " + errorBody);
                })
                .build();
    }

}