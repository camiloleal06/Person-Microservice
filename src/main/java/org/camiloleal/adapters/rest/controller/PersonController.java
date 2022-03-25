package org.camiloleal.adapters.rest.controller;

import lombok.AllArgsConstructor;
import org.camiloleal.domain.inports.PersonInterface;
import org.camiloleal.domain.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonInterface personService;

    @GetMapping
    public List<Person> findAllPeople() {
            return this.personService.findAll();
    }
}
