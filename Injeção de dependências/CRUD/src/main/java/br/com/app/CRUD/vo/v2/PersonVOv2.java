package br.com.app.CRUD.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOv2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthday;

    public PersonVOv2() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVOv2 that)) return false;
        return getId() == that.getId() && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getAddress().equals(that.getAddress()) && getGender().equals(that.getGender()) && getBirthday().equals(that.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getGender(), getBirthday());
    }
}
