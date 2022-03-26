package org.camiloleal.adapters.rest.controller;

import org.camiloleal.adapters.bd.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.camiloleal.domain.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    private final PersonServiceImpl personService = mock(PersonServiceImpl.class);

    private final Person personDomain = mock(Person.class);

    private final PersonController personController = new PersonController(personService);


    @Test
    void shouldCallServiceCreate() {
        //when(personService.create(personDomain)).thenReturn(personDomain);
        personController.createPerson(personDomain);
        verify(personService, times(1)).create(personDomain);
    }

    @Test
    void shouldCallServiceFindAll() {
     //   when(personService.findAll()).thenReturn(listPerson);
     //   assertFalse(personController.findAllPeople().isEmpty());
       // assertEquals(2, personController.findAllPeople().size());
        personController.findAllPeople();
        verify(personService, times(1)).findAll();
    }

    @Test
    void shouldCallServiceGetPersonById() {
        //when(personService.getPersonById(ID)).thenReturn(personDomain);
        //assertNotNull(personController.findPersonById(ID));
        personController.findPersonById(anyInt());
        verify(personService, times(1)).getPersonById(anyInt());
    }


}