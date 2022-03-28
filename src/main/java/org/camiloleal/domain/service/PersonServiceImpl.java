package org.camiloleal.domain.service;

import lombok.AllArgsConstructor;
import org.camiloleal.ports.PersonInterface;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonInterface {

    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person create(Person person) {
        return personRepository.create(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.getPersonByEmail(email);
    }
}
