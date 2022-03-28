package org.camiloleal.adapters.bd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class PersonPersistenceMysqlTest {

    @Autowired
    PersonRepository personRepository;

    PersonEntity person = new PersonEntity();

    @BeforeEach
    void setUp() {

        person.setDni("73207634");
        person.setCity("Cartagena");
        person.setEmail("camiloleal22@gmail.com");
        person.setFirstName("camilo");
        person.setLastName("Leal");
        person.setOld(35);
        person.setPhone("73207642");

    }

    @Test
    void findAll() {
        personRepository.findAll();
        assertFalse(personRepository.findAll().isEmpty());
    }

    @Test
    @Rollback
    void create() {
        assertNotNull(personRepository.save(person));
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
}