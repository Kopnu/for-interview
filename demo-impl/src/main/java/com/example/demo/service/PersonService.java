package com.example.demo.service;

import com.example.demo.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Person service.
 *
 * @author Sergei_Kornilov
 */
public interface PersonService {

    Person create(Person person);

    Person find(Long id);

    List<Person> findAll();

    Page<Person> findAll(Pageable pageable);

    Person update(Person person);

    void delete(Long id);

}
