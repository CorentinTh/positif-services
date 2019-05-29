/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Client extends Person{

    public Client() {
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getChineseSign() {
        return chineseSign;
    }

    public void setChineseSign(String chineseSign) {
        this.chineseSign = chineseSign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    public void addConsultation(Consultation consultation){
        this.consultations.add(consultation);
    }
    
    private String zodiacSign;
    private String chineseSign;
    private String color;
    private String animal;
    private Address address;
    private String phoneNumber;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @OneToMany(mappedBy="client")
    private List<Consultation> consultations;


    public Client(Address address, String phoneNumber, String email, String lastname, String firstname, String gender, String password, Date birthDate) {
        super(email, lastname, firstname, gender, password, birthDate);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
   
    
    
}
