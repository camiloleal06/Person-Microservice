package org.camiloleal.adapters.rest.controller;

import org.camiloleal.adapters.bd.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.camiloleal.domain.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    private final PersonController personController = new PersonController(personService);

    PersonEntity person = new PersonEntity("73207639", "Camilo Jesús", "Leal Patiño", "camiloleal@gmail.com", "3225996394", 37, "Cartagena");

    Person personDomain = person.toPerson();


    @Test
    void shouldCallServiceCreatePerson() {
        when(personService.create(personDomain)).thenReturn(personDomain);
        personController.createPerson(personDomain);
        assertEquals("Cartagena", personService.create(personDomain).getCity());
        verify(personService, times(2)).create(personDomain);
    }

    @Test
    void shouldCallServiceFindAllPeople() {
        when(personService.findAll()).thenReturn(Arrays.asList(personDomain));
        assertFalse(personController.findAllPeople().isEmpty());
        verify(personService, times(1)).findAll();
    }
}