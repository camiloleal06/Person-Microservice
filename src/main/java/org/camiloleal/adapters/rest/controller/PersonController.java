package org.camiloleal.adapters.rest.controller;

import lombok.AllArgsConstructor;

import org.camiloleal.ports.in_ports.PersonInterface;
import org.camiloleal.domain.model.Person;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return this.personService.create(person);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Integer id) {
        return this.personService.getPersonById(id);
    }
}
