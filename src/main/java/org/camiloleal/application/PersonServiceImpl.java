package org.camiloleal.application;

import lombok.AllArgsConstructor;
import org.camiloleal.domain.PersonInterface;
import org.camiloleal.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonInterface {

    private PersonPersistence personPersistence;

    @Override
    public List<Person> findAll() {
        return personPersistence.findAll();
    }

    @Override
    public Person create(Person person) {
        return personPersistence.create(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personPersistence.getPersonById(id);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personPersistence.getPersonByEmail(email);
    }
}