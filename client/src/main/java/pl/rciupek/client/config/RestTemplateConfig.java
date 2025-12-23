package pl.rciupek.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate(final OAuth2AuthorizedClientManager manager) {
    final ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
      final OAuth2AuthorizeRequest authRequest = OAuth2AuthorizeRequest.withClientRegistrationId("keycloak")
          .principal("demo-app")
          .build();

      final OAuth2AuthorizedClient client = manager.authorize(authRequest);

      request.getHeaders().setBearerAuth(client.getAccessToken().getTokenValue());

      return execution.execute(request, body);
    };

    final RestTemplate restTemplate = new RestTemplate();
    restTemplate.getInterceptors().add(interceptor);

    return restTemplate;
  }
}
