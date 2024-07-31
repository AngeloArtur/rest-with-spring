package br.com.app.CRUD.controllers;

import br.com.app.CRUD.data.vo.PersonVO;
import br.com.app.CRUD.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() throws Exception {
        return personService.findAll();
    }
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(
            @PathVariable(value = "id") Long id) throws Exception {
        return personService.findById(id);
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(
            @RequestBody PersonVO person) throws Exception {
        return personService.create(person);
    }

    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(
            @RequestBody PersonVO person) throws Exception {
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id)
            throws Exception {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
