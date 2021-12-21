package com.example.demo.resource.impl;

import com.example.demo.domain.Person;
import com.example.demo.dto.PersonDto;
import com.example.demo.resource.PersonResource;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of {@link PersonResource}.
 *
 * @author Sergei_Kornilov
 */
@RestController
@RequiredArgsConstructor
public class PersonResourceImpl implements PersonResource {

    private final MapperFacade mapperFacade;
    private final PersonService personService;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = mapperFacade.map(personDto, Person.class);
        return mapperFacade.map(personService.create(person), PersonDto.class);
    }

    @Override
    public PersonDto getPerson(Long id) {
        return mapperFacade.map(personService.find(id), PersonDto.class);
    }

    @Override
    public List<PersonDto> getPersonPage(Integer page, Integer size) {
        return mapperFacade.mapAsList(personService.findAll(PageRequest.of(page, size)), PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person person = mapperFacade.map(personDto, Person.class);
        return mapperFacade.map(personService.update(person), PersonDto.class);
    }

    @Override
    public void delete(Long id) {
        personService.delete(id);
    }
}
