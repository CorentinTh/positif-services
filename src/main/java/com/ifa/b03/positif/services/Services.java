/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.services;

import com.ifa.b03.positif.dao.*;
import com.ifa.b03.positif.entities.*;

import static com.ifa.b03.positif.entities.PredictionType.*;

import com.ifa.b03.positif.utils.Astro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cthomasset
 */
public class Services {

    public static boolean checkCredentials(String email, String password) {
        JpaUtil.createEntityManager();

        Person person = PersonDao.getPersonByCred(email, password);

        JpaUtil.closeEntityManager();

        return person != null;
    }

    public static List<Prediction> generatePredictions(Consultation consultation, int loveLevel, int healthLevel, int workLevel) {
        List<Prediction> predictions = new ArrayList<>();
        Astro astro = new Astro();

        try {
            List<String> results = astro.getPredictions(consultation.getClient().getColor(), consultation.getClient().getAnimal(), loveLevel, healthLevel, workLevel);

            predictions.add(new Prediction(LOVE, loveLevel, results.get(0), consultation));
            predictions.add(new Prediction(HEALTH, healthLevel, results.get(1), consultation));
            predictions.add(new Prediction(WORK, workLevel, results.get(2), consultation));

        } catch (IOException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

        return predictions;
    }

    public static void registerClient(Client client) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        try {
            ServicesUtils.validateAndGenerateGpsAddress(client.getAddress());
            ServicesUtils.generateAstralProfile(client);
            ClientDao.persist(client);

            JpaUtil.validateTransaction();
        } catch (Exception e) {
            JpaUtil.cancelTransaction();
        }

        JpaUtil.closeEntityManager();
    }

    public static List<Medium> getMediums(int pageNumber, int pageSize) {
        JpaUtil.createEntityManager();

        List<Medium> mediums = MediumDao.getMediums(pageNumber, pageSize);

        JpaUtil.closeEntityManager();

        return mediums;
    }

    public static List<Client> getClients(int pageNumber, int pageSize) {
        JpaUtil.createEntityManager();

        List<Client> clients = ClientDao.getClients(pageNumber, pageSize);

        JpaUtil.closeEntityManager();

        return clients;
    }

    public static Client getInfoClient(Long clientID) {
        JpaUtil.createEntityManager();

        Client client = ClientDao.getClientById(clientID);

        JpaUtil.closeEntityManager();

        return client;
    }

    public static boolean initConsultation(Client client, Medium medium) {
        boolean status = false;

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        Employee employee = EmployeeDao.getEmployeeForConsultation(medium.getExperienceRequired(), medium.getVoiceType());

        if (employee != null) {
            Consultation consultation = new Consultation(client, medium, employee);

            ConsultationDao.persist(consultation);
            JpaUtil.validateTransaction();
            status = true;

            // TODO: notify employee
        } else {
            JpaUtil.cancelTransaction();
        }

        JpaUtil.closeEntityManager();

        return status;
    }



    public static void acceptConsultation(Consultation consultation) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        consultation.setAnsweredAt(new Date());
        consultation.setState(ConsultationStateType.PENDING);

        ConsultationDao.persist(consultation);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();

        // TODO: notify client
    }

    public static void closeConsultation(Consultation consultation, String comment, Date closedAt) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        consultation.setClosedAt(closedAt);
        consultation.setComment(comment);
        consultation.setState(ConsultationStateType.CLOSED);

        ConsultationDao.persist(consultation);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static Consultation getConsultation(Long consultationID){
        JpaUtil.createEntityManager();

        Consultation consultation = ConsultationDao.getConsultationById(consultationID);

        JpaUtil.closeEntityManager();

        return consultation;
    }

    public static Consultation getCurrentConsultation(Employee employee){
        JpaUtil.createEntityManager();

        Consultation consultation = ConsultationDao.getCurrentConsultationByEmployee(employee);

        JpaUtil.closeEntityManager();

        return consultation;
    }

    public static List<Consultation> getConsultationByClient(Client client){
        JpaUtil.createEntityManager();

        List<Consultation> consultations = ConsultationDao.getConsultationsByClient(client);

        JpaUtil.closeEntityManager();

        return consultations;
    }


    public static void setPredictionsForConsultation(Consultation consultation, List<Prediction> predictions){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        consultation.setPredictions(predictions);

        PredictionDao.persist(predictions);
        ConsultationDao.persist(consultation);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }


    // TODO: setPredictions

}
