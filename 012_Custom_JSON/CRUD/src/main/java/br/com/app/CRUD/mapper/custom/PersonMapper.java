package br.com.app.CRUD.mapper.custom;

import br.com.app.CRUD.data.model.Person;
import br.com.app.CRUD.data.vo.v2.PersonVOv2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOv2 convertEntityToVo(Person person) {
        PersonVOv2 vo = new PersonVOv2();

        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
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
