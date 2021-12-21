package com.example.demo.service.impl;

import com.example.demo.domain.Person;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation od {@link PersonService}.
 *
 * @author Sergei_Kornilov
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    @Override
    public Person find(Long id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person update(Person person) {
        boolean exists = personRepository.existsById(person.getId());
        if (exists) {
            return personRepository.save(person);
        }
        throw new PersonNotFoundException();
    }

    @Override
    public void delete(Long id) {
        Person person = find(id);
        personRepository.delete(person);
    }
}
