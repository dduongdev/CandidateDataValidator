package com.dduongdev.entities;

import com.dduongdev.entities.exceptions.IncorrectDataFormatException;
import com.dduongdev.utils.Validator;

import java.util.Objects;

public class Candidate {
    private String name;
    private String birthdate;
    private String address;
    private String hometown;
    private String phone;
    private String email;

    public Candidate() {
        super();
    }

    public Candidate(String name, String birthdate, String address, String hometown, String phone, String email) {
        super();
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.hometown = hometown;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) throws IncorrectDataFormatException {
        if(!Validator.isBirthdate(birthdate))
            throw new IncorrectDataFormatException();
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IncorrectDataFormatException {
        if(!Validator.isPhone(phone)) {
            throw new IncorrectDataFormatException();
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IncorrectDataFormatException {
        if(!Validator.isEmail(email)) {
            throw new IncorrectDataFormatException();
        }
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((hometown == null) ? 0 : hometown.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Candidate other = (Candidate) obj;
        return Objects.equals(this.address, other.address) && Objects.equals(this.birthdate, other.birthdate)
                && Objects.equals(this.email, other.email) && Objects.equals(this.hometown, other.hometown)
                && Objects.equals(this.name, other.name) && Objects.equals(phone, other.phone);
    }
}
