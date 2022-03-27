package org.camiloleal.domain.service;

import org.camiloleal.adapters.bd.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PersonServiceImplTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    final int ID = 1;

    PersonEntity person = PersonEntity.builder().build();

    Person personDomain = person.toPerson();

    Person personDomain2 = person.toPerson();

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
        verify(personService, times(1)).findAll();
    }

    @Test
    void shouldCallServiceGetPersonById() {
        when(personService.getPersonById(ID)).thenReturn(personDomain);
        assertNotEquals(null, personService.getPersonById(ID));
        verify(personService, times(1)).getPersonById(ID);
    }
}