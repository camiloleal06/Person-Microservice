package org.camiloleal.adapters.bd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
