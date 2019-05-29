/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    private String comment;
    
    @Temporal(TemporalType.DATE)
    private Date createdAt;
   
    @Temporal(TemporalType.DATE)
    private Date answeredAt;
    
    @Temporal(TemporalType.DATE)
    private Date closeAt;

    @ManyToOne
    private Medium medium;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Client client;
    
    @OneToMany(mappedBy="employee")
    private List<Consultation> consultations;

    public Consultation(String comment, Date createdAt, Medium medium, Employee employee, Client client, List<Consultation> consultations) {
        this.comment = comment;
        this.createdAt = createdAt;
        this.medium = medium;
        this.employee = employee;
        this.client = client;
        this.consultations = consultations;
    }
    
    public Consultation() {
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(Date answeredAt) {
        this.answeredAt = answeredAt;
    }

    public Date getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(Date closeAt) {
        this.closeAt = closeAt;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    
}
