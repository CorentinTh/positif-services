/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable { // /!\ User : mot clé réservé par psql
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String email;
    private String lastname;
    private String firstname;
    private String gender;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public Person(String email, String lastname, String firstname, String gender, String password, Date birthDate) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.gender = gender;
        this.password = password;
        this.birthDate = birthDate;
    }
    
    public Person()
    { }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
