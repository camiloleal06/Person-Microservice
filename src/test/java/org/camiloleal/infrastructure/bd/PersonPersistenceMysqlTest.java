package org.camiloleal.infrastructure.bd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.camiloleal.domain.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class PersonPersistenceMysqlTest {

    @Autowired
    PersonPersistenceMysql personPersistenceMysql;

    @MockBean
    PersonRepository personRepository;

    PersonEntity personEntity = new PersonEntity(1, "73207639", "Camilo", "Leal", "ingenierocamiloleal@gmail.com",
            "3225996394", 30, "Cartagena");

    @BeforeEach
    void setUp() {

        personRepository = mock(PersonRepository.class);
        personPersistenceMysql = new PersonPersistenceMysql(personRepository);

    }

    @Test
    void findAll() {
        when(personRepository.findById(1)).thenReturn(Optional.of(personEntity));
        Person person = personPersistenceMysql.getPersonById(1);
        assertNotNull(person);
    }

    @Test
    void getPersonById() {
        when(personRepository.findById(1)).thenReturn(Optional.of(personEntity));
        Person person = personPersistenceMysql.getPersonById(1);
        assertNotNull(person);
        assertEquals("73207639", person.getDni());
    }

    @Test
    void getPersonByEmail() {
        assertNotNull(personRepository.findByEmail("camiloleal06@gmail.com"));
        assertEquals("Cartagena", personRepository.findByEmail("camiloleal06@gmail.com").getCity());
    }

}