package lk.ijse.dep.dto;

import lk.ijse.dep.entity.Gender;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/
public class StudentDTO implements Serializable {
    private int id;
    private String contact;
    private String name;
    private Date dob;
    private Gender gender;
    private Address address;

    public StudentDTO() {
    }

    public StudentDTO(int id, String contact, String name, Date dob, Gender gender, Address address) {
        this.id = id;
        this.contact = contact;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", address=" + address +
                '}';
    }
}
