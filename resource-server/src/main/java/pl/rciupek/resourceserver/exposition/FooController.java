package pl.rciupek.resourceserver.exposition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.rciupek.resourceserver.model.Foo;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.insecure;

@RestController
@RequestMapping(value = "/api/foos")
@Slf4j
public class FooController {

  @GetMapping(value = "/{id}")
  public Foo get(@PathVariable final Long id) {
    return new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4));
  }

  @GetMapping
  public List<Foo> findAll() {
    final List<Foo> foos = new ArrayList<>();
    foos.add(new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4)));
    foos.add(new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4)));
    foos.add(new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4)));
    foos.add(new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4)));
    foos.add(new Foo(Long.parseLong(insecure().nextNumeric(2)), insecure().nextAlphabetic(4)));
    return foos;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public Foo create(@RequestBody final Foo foo) {
    log.info("Creating foo: {}", foo);
    return null;
  }
}
