package org.camiloleal.infrastructure.bd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonPersistenceMysqlTest {

    @Autowired
    PersonRepository personRepository;

    PersonEntity person = new PersonEntity();

    @BeforeEach
    void setUp() {
        person.setDni("73207333");
        person.setCity("Cartagena");
        person.setEmail("camiloleal2022@gmail.com");
        person.setFirstName("camilo");
        person.setLastName("Leal");
        person.setOld(35);
        person.setPhone("73207343");

    }

    @Test
    void findAll() {
        personRepository.findAll();
        assertFalse(personRepository.findAll().isEmpty());
    }
    @Test
    void getPersonById() {
        assertNotNull(personRepository.getById(1));
    }

    @Test
    void getPersonByEmail() {
        assertNotNull(personRepository.findByEmail("camiloleal06@gmail.com"));
        assertEquals("Cartagena", personRepository.findByEmail("camiloleal06@gmail.com").getCity());
    }
    @Test
    @Rollback
    void create() {
        assertNotNull(personRepository.save(person));
    }


}