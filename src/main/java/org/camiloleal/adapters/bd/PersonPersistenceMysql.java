package org.camiloleal.adapters.bd;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.out_ports.PersonPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Repository("personPersistence")
public class PersonPersistenceMysql implements PersonPersistence {

    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonEntity::toPerson).collect(Collectors.toList());
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(new PersonEntity(person)).toPerson();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(RuntimeException::new).toPerson();
    }
}
