package com.example.demo.resource;

import com.example.demo.dto.PersonDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Person api resource.
 *
 * @author Sergei_Kornilov
 */
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public interface PersonResource {

    @PostMapping
    PersonDto createPerson(@RequestBody PersonDto personDto);

    @GetMapping("/{id}")
    PersonDto getPerson(@PathVariable Long id);

    @GetMapping
    List<PersonDto> getPersonPage(@RequestParam Integer page,
                                  @RequestParam Integer size);

    @PutMapping
    PersonDto updatePerson(@RequestBody PersonDto personDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

}
