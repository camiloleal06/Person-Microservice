package org.camiloleal.infrastructure.bd;

import org.camiloleal.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    Person findByEmail(String email);
}
