package br.com.app.CRUD.repositories;

import br.com.app.CRUD.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
