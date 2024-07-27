package br.com.app.CRUD.services;

import br.com.app.CRUD.exceptions.ResourceNotFoundException;
import br.com.app.CRUD.model.Person;
import br.com.app.CRUD.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;
    public List<Person> findAll() {
        logger.info("Find all persons");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find one person!");

        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update one person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete one person!");

        Person entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );
        repository.delete(entity);
    }

}
