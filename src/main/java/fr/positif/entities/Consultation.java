/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String comment;
    
    @Temporal(TemporalType.DATE)
    private Date createdAt;
   
    @Temporal(TemporalType.DATE)
    private Date answeredAt;
    
    @Temporal(TemporalType.DATE)
    private Date closedAt;

    @Enumerated(EnumType.STRING)
    private ConsultationStateType state;

    @ManyToOne
    private Medium medium;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Client client;
    
    @OneToMany(mappedBy = "consultation")
    private List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public ConsultationStateType getState() {
        return state;
    }

    public void setState(ConsultationStateType state) {
        this.state = state;
    }

    public Consultation(Client client, Medium medium, Employee employee) {
        this.createdAt = new Date();
        this.medium = medium;
        this.employee = employee;
        this.client = client;
        this.state = ConsultationStateType.WAITING_VALIDATION;
        
        client.addConsultation(this);
        medium.addConsultation(this);
        employee.addConsultation(this);
    }
    
    public Consultation() {
    }

    public Long getId() {
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

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closeAt) {
        this.closedAt = closeAt;
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

    
}
