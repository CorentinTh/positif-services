/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PredictionType type;
    private Integer degree;
    private String content;

    @ManyToOne
    private Consultation consultation;

    public Prediction(PredictionType type, Integer degree, String content) {
        this.type = type;
        this.degree = degree;
        this.content = content;
    }

    protected Prediction() {
    }
    
    public PredictionType getType() {
        return type;
    }

    public void setType(PredictionType type) {
        this.type = type;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
