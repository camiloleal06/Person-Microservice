package org.camiloleal.adapters.rest.controller;

import lombok.AllArgsConstructor;
import org.camiloleal.adapters.bd.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.camiloleal.domain.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AllArgsConstructor
class PersonControllerTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    private final PersonController personController = new PersonController(personService);

    @Test
    void shouldCallServiceCreatePerson() {
        PersonEntity person = new PersonEntity();
        person.setPhone("3003254591");
        person.setOld(30);
        person.setLastName("Leal");
        person.setFirstName("camilo");
        person.setEmail("camiloleal@gmail.com");
        person.setCity("Cartagena");
        Person personDomain = person.toPerson();
        personController.createPerson(personDomain);
        verify(personService, times(1)).create(personDomain);
    }
}