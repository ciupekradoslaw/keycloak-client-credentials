package pl.rciupek.client.exposition;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rciupek.client.application.FooService;
import pl.rciupek.client.model.Foo;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FooController {

  private final FooService fooService;

  @GetMapping("/api/foos")
  public List<Foo> getFoos() {
    return fooService.getFoos();
  }
}