package com.example.demo.repository;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Person entity.
 *
 * @author Sergei_Kornilov
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
