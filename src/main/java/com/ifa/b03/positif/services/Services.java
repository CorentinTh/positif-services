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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cthomasset
 */
public class Services {

    public static Medium getMedium(Long mediumID){
        JpaUtil.createEntityManager();

        Medium medium = MediumDao.getMediumByID(mediumID);

        JpaUtil.closeEntityManager();

        return medium;
    }

    public static List<Medium> getMediums(int pageNumber, int pageSize) {
        JpaUtil.createEntityManager();

        List<Medium> mediums = MediumDao.getMediums(pageNumber, pageSize);

        JpaUtil.closeEntityManager();

        return mediums;
    }

    public static Person getPerson(Long personID) {
        JpaUtil.createEntityManager();

        Person person = PersonDao.getPersonByID(personID);

        JpaUtil.closeEntityManager();

        return person;
    }

    public static Consultation getConsultation(Long consultationID) {
        JpaUtil.createEntityManager();

        Consultation consultation = ConsultationDao.getConsultationById(consultationID);

        JpaUtil.closeEntityManager();

        return consultation;
    }

    public static List<Client> getClients(int pageNumber, int pageSize) {
        JpaUtil.createEntityManager();

        List<Client> clients = ClientDao.getClients(pageNumber, pageSize);

        JpaUtil.closeEntityManager();

        return clients;
    }


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

            predictions.add(new Prediction(LOVE, loveLevel, results.get(0)));
            predictions.add(new Prediction(HEALTH, healthLevel, results.get(1)));
            predictions.add(new Prediction(WORK, workLevel, results.get(2)));

        } catch (IOException ex) {
            // TODO
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

    public static Consultation getCurrentConsultation(Employee employee) {
        JpaUtil.createEntityManager();

        Consultation consultation = ConsultationDao.getCurrentConsultationByEmployee(employee);

        JpaUtil.closeEntityManager();

        return consultation;
    }

    public static List<Consultation> getConsultationByClient(Client client) {
        JpaUtil.createEntityManager();

        List<Consultation> consultations = ConsultationDao.getConsultationsByClient(client);

        JpaUtil.closeEntityManager();

        return consultations;
    }

    public static List<Consultation> getCurrentConsultationByClient(Client client) {
        JpaUtil.createEntityManager();

        List<Consultation> consultations = ConsultationDao.getCurrentConsultationByClient(client);

        JpaUtil.closeEntityManager();

        return consultations;
    }

    public static void setPredictionsForConsultation(Consultation consultation, List<Prediction> predictions) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        for (Prediction prediction : predictions) {
            prediction.setConsultation(consultation);
        }

        consultation.setPredictions(predictions);

        PredictionDao.persist(predictions);
        ConsultationDao.persist(consultation);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static Map<Medium, Long> getClientCountByMedium(){
        JpaUtil.createEntityManager();

        Map<Medium, Long> counts = MediumDao.getClientCountByMedium();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Medium, Double> getConsultationTimeAverageByMedium(){
        JpaUtil.createEntityManager();

        Map<Medium, Double> counts = MediumDao.getConsultationTimeAverageByMedium();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Medium, List<Long>> getClientCountByMediumPerDay(){
        JpaUtil.createEntityManager();

        Map<Medium, List<Long>> counts = MediumDao.getClientCountByMediumPerDay();

        JpaUtil.closeEntityManager();

        return counts;
    }


    public static Map<Client, List<Long>> getClientCountByEmployeePerDay(){
        JpaUtil.createEntityManager();

        Map<Client, List<Long>> counts = EmployeeDao.getClientCountByEmployeePerDay();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Client, Long> getClientCountByEmployee(){
        JpaUtil.createEntityManager();

        Map<Client, Long> counts = EmployeeDao.getClientCountByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Client, Medium> getFavoriteMediumByEmployee(){
        JpaUtil.createEntityManager();

        Map<Client, Medium> counts = EmployeeDao.getFavoriteMediumByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Client, Double> getConsultationTimeAverageByEmployee(){
        JpaUtil.createEntityManager();

        Map<Client, Double> counts = EmployeeDao.getConsultationTimeAverageByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }


}
