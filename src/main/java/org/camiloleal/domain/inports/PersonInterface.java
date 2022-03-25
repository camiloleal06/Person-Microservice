package org.camiloleal.domain.inports;

import org.camiloleal.domain.model.Person;

import java.util.List;

public interface PersonInterface {
    List<Person> findAll();
    Person create(Person person);

}
