/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Employee extends Person {
    private VoiceType voiceType;
    private ExperienceType experience;

    public Employee() {
       super();
    }

    public Employee(VoiceType voiceType, ExperienceType experience, String email, String lastname, String firstname, String gender, String password, Date birthDate) {
        super(email, lastname, firstname, gender, password, birthDate);
        this.voiceType = voiceType;
        this.experience = experience;
    }
    
    
    
    
}
