package org.camiloleal.infrastructure.bd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.camiloleal.domain.model.Person;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;
    private String city;

    public Person toPerson() {
        Person person = new Person();
        BeanUtils.copyProperties(this, person);
        return person;
    }

    public PersonEntity(Person person) {
        BeanUtils.copyProperties(person, this);
    }

}
