package org.camiloleal.domain.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Integer id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;
    private String city;
}
