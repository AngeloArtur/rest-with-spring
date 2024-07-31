package br.com.app.CRUD.services;

import br.com.app.CRUD.data.vo.v1.PersonVO;
import br.com.app.CRUD.data.vo.v2.PersonVOv2;
import br.com.app.CRUD.exceptions.ResourceNotFoundException;
import br.com.app.CRUD.mapper.DozerMapper;
import br.com.app.CRUD.mapper.custom.PersonMapper;
import br.com.app.CRUD.data.model.Person;
import br.com.app.CRUD.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;
    public List<PersonVO> findAll() {
        logger.info("Find all persons");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Find one person!");

        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOv2 createV2(PersonVOv2 person) {

        logger.info("Creating one person with V2!");
        var entity = mapper.convertVoToEntity(person);
        var vo =  mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }


    public PersonVO update(PersonVO person) {
        logger.info("Update one person!");
        var entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Delete one person!");

        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );
        repository.delete(entity);
    }

}
