package org.camiloleal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int old;
    private String city;
}
