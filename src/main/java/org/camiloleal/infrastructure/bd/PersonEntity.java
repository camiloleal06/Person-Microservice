package org.camiloleal.infrastructure.bd;

import lombok.*;
import org.camiloleal.domain.model.Person;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String dni;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String email;
    @Column(length = 12)
    private String phone;
    private int old;
    @Column(length = 50)
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
