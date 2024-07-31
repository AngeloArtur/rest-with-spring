package br.com.app.CRUD.mapper.custom;

import br.com.app.CRUD.data.model.Person;
import br.com.app.CRUD.data.vo.v2.PersonVOv2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOv2 convertEntityToVo(Person person) {
        PersonVOv2 personVOv2 = new PersonVOv2();

        personVOv2.setId(person.getId());
        personVOv2.setFirstName(person.getFirstName());
        personVOv2.setLastName(person.getLastName());
        personVOv2.setGender(person.getGender());
        personVOv2.setBirthDay(new Date());
        personVOv2.setAddress(person.getAddress());

        return personVOv2;
    }

    public Person convertVoToEntity(PersonVOv2 person) {
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        
        return entity;
    }
}
