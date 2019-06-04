/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Employee extends Person {
    @Enumerated(EnumType.STRING)
    private VoiceType voiceType;

    @Enumerated(EnumType.STRING)
    private ExperienceType experience;

    public Employee() {
       super();
    }

    public Employee(VoiceType voiceType, ExperienceType experience, String email, String lastname, String firstname, String gender, String password, Date birthDate) {
        super(email, lastname, firstname, gender, password, birthDate);
        this.voiceType = voiceType;
        this.experience = experience;
    }
    
    @OneToMany(mappedBy="employee")
    private List<Consultation> consultations;

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public VoiceType getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(VoiceType voiceType) {
        this.voiceType = voiceType;
    }

    public ExperienceType getExperience() {
        return experience;
    }

    public void setExperience(ExperienceType experience) {
        this.experience = experience;
    }
    
    public void addConsultation(Consultation consultation){
        this.consultations.add(consultation);
    }
    
}
