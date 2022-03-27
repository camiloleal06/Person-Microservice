package org.camiloleal.domain.service;

import org.camiloleal.adapters.bd.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    final int ID = 1;

    PersonEntity person = PersonEntity.builder().build();

    Person personDomain = Person.builder().
            id(1)
            .dni("73207639")
            .city("Cartagena")
            .email("camiloleal@gmail.com")
            .firstName("camilo")
            .lastName("Leal")
            .old(35)
            .phone("73207639")
            .build();

    Person personDomain2 = Person.builder().
            id(1)
            .dni("73207638")
            .city("Cartagena")
            .email("camiloleal3@gmail.com")
            .firstName("camilo")
            .lastName("Leal")
            .old(30)
            .phone("73207637")
            .build();

    List<Person> listPerson = Arrays.asList(personDomain, personDomain2);

    @Test
    void shouldCallServiceCreate() {
        when(personService.create(personDomain)).thenReturn(personDomain);
        assertNotNull(personService.create(personDomain));
        verify(personService, times(1)).create(personDomain);
    }

    @Test
    void shouldCallServiceFindAll() {
        when(personService.findAll()).thenReturn(listPerson);
        assertFalse(personService.findAll().isEmpty());
        assertEquals(2, personService.findAll().size());
        verify(personService, times(2)).findAll();
    }

    @Test
    void shouldCallServiceGetPersonById() {
        when(personService.getPersonById(ID)).thenReturn(personDomain);
        assertNotEquals(null, personService.getPersonById(ID));
        assertEquals("73207639",personService.getPersonById(ID).getDni());
        verify(personService, times(2)).getPersonById(ID);
    }
}