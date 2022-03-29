package org.camiloleal.domain.service;

import org.camiloleal.application.PersonServiceImpl;
import org.camiloleal.domain.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceImplTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    final int ID = 1;

    final String EMAIL = "camiloleal@gmail.com";

    Person personDomain = Person.builder().
            id(1)
            .dni("73207639")
            .city("Cartagena")
            .email("camiloleal@gmail.com")
            .firstName("camilo")
            .lastName("Leal")
            .age(35)
            .phone("73207639")
            .build();
    List<Person> listPerson = List.of(personDomain);

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
        assertEquals(1, personService.findAll().size());
        verify(personService, times(2)).findAll();
    }

    @Test
    void shouldCallServiceGetPersonById() {
        when(personService.getPersonById(ID)).thenReturn(personDomain);
        assertNotEquals(null, personService.getPersonById(ID));
        assertEquals("73207639", personService.getPersonById(ID).getDni());
        assertEquals("Cartagena", personService.getPersonById(ID).getCity());
        verify(personService, times(3)).getPersonById(ID);
    }

    @Test
    void shouldCallServiceGetPersonByEmail() {
        when(personService.getPersonByEmail(EMAIL)).thenReturn(personDomain);
        assertNotEquals(null, personService.getPersonByEmail(EMAIL));
        assertEquals("73207639", personService.getPersonByEmail(EMAIL).getDni());
              verify(personService, times(2)).getPersonByEmail(EMAIL);
    }

}