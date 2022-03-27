package org.camiloleal.domain.outports;

import org.camiloleal.domain.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonPersistence {
    List<Person> findAll();
    Person create(Person person);
    Person getPersonById(Integer id);
    Person getPersonByEmail(String email);
}
