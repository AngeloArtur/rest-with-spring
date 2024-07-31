package br.com.app.mapper.custom;

import br.com.app.data.vo.v2.PersonVOv2;
import br.com.app.data.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOv2 convertEntityToVo(Person person) {
        PersonVOv2 vo = new PersonVOv2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setBirthday(new Date());

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