package org.camiloleal.ports;

import org.camiloleal.domain.model.Person;

import java.util.List;

public interface PersonInterface {
    List<Person> findAll();
    Person create(Person person);
    Person getPersonById(Integer id);
    Person getPersonByEmail(String email);

}
