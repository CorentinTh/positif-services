package fr.positif.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private TalentType talent;

    private String description;
    private String picturePath;

    @Enumerated(EnumType.STRING)
    private VoiceType voiceType;

    @Override
    public String toString() {
        return "Medium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", talent=" + talent +
                ", description='" + description + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", voiceType=" + voiceType +
                ", experienceRequired=" + experienceRequired +
                ", trainig='" + trainig + '\'' +
                ", speciality='" + speciality + '\'' +
                ", schoolYear=" + schoolYear +
                '}';
    }

    @Enumerated(EnumType.STRING)
    private ExperienceType experienceRequired;

    private String trainig;
    private String speciality;
    private Integer schoolYear;

    @OneToMany(mappedBy = "medium")
    private List<Consultation> consultations;

    public Long getId() {
        return id;
    }

    public Medium() {
    }

    public Medium(String name, TalentType talent, String description, VoiceType voiceType, ExperienceType experienceRequired) {
        this.name = name;
        this.talent = talent;
        this.description = description;
        this.voiceType = voiceType;
        this.experienceRequired = experienceRequired;
    }

    public void addConsultation(Consultation consultation) {
        this.consultations.add(consultation);
    }

    public String getName() {
        return name;
    }

    public Medium setName(String name) {
        this.name = name;
        return this;
    }

    public TalentType getTalent() {
        return talent;

    }

    public Medium setTalent(TalentType talent) {
        this.talent = talent;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Medium setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public Medium setPicturePath(String picturePath) {
        this.picturePath = picturePath;
        return this;
    }

    public VoiceType getVoiceType() {
        return voiceType;
    }

    public Medium setVoiceType(VoiceType voiceType) {
        this.voiceType = voiceType;
        return this;
    }

    public ExperienceType getExperienceRequired() {
        return experienceRequired;
    }

    public Medium setExperienceRequired(ExperienceType experienceRequired) {
        this.experienceRequired = experienceRequired;
        return this;
    }

    public String getTrainig() {
        return trainig;
    }

    public Medium setTrainig(String trainig) {
        this.trainig = trainig;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Medium setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public Medium setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
        return this;
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
