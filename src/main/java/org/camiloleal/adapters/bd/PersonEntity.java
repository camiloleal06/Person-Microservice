package org.camiloleal.adapters.bd;

import lombok.Getter;
import lombok.Setter;
import org.camiloleal.domain.model.Person;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String dni;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50, unique = true)
    private String email;
    @Column(length = 12, unique = true)
    private String phone;
    private int old;
    @Column(length = 50)
    private String city;

    public PersonEntity(String dni, String firstName, String lastName, String email, String phone, int old, String city) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.old = old;
        this.city = city;
    }

    public Person toPerson() {
        Person person = new Person();
       BeanUtils.copyProperties(this, person);
       return person;
          }

    public PersonEntity(Person person) {
        BeanUtils.copyProperties(person, this);
    }

}
