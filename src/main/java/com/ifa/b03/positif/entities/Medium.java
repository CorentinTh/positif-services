package com.ifa.b03.positif.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private TalentType talent;
    private String description;
    private String picturePath;

    @Enumerated(EnumType.STRING)
    private VoiceType voiceType;

    @Enumerated(EnumType.STRING)
    private ExperienceType experienceRequired;

    private String trainig;
    private String speciality;
    private Integer schoolYear;

    private Long price;

    @OneToMany(mappedBy = "medium")
    private List<Consultation> consultations;

    public Long getId() {
        return id;
    }

    public Medium() {
    }

    public Medium(String name, TalentType talent, String description, VoiceType voiceType, ExperienceType experienceRequired, Long price) {
        this.name = name;
        this.talent = talent;
        this.description = description;
        this.voiceType = voiceType;
        this.experienceRequired = experienceRequired;
        this.price = price;
    }

    public void addConsultation(Consultation consultation) {
        this.consultations.add(consultation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TalentType getTalent() {
        return talent;
    }

    public void setTalent(TalentType talent) {
        this.talent = talent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public VoiceType getVoiceType() {
        return voiceType;
    }

    public void setVoiceType(VoiceType voiceType) {
        this.voiceType = voiceType;
    }

    public ExperienceType getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(ExperienceType experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getTrainig() {
        return trainig;
    }

    public void setTrainig(String trainig) {
        this.trainig = trainig;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium medium = (Medium) o;
        return id.equals(medium.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
