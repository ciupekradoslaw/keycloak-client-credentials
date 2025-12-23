package pl.rciupek.client.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rciupek.client.model.Foo;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FooService {

  private final RestTemplate restTemplate;

  public List<Foo> getFoos() {
    return Arrays.asList(restTemplate.getForObject("http://localhost:8081/api/foos", Foo[].class));
  }
}
