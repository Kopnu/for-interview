package com.example.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Person entity.
 *
 * @author Sergei_Konilov
 */
@Data
@Entity
@Accessors(chain = true)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_default_seq")
    @SequenceGenerator(name = "person_default_seq", sequenceName = "person_default_seq", initialValue = 5163, allocationSize = 1)
    private Long id;

    private String name;

    private Integer age;

}
