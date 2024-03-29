/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.services;

import fr.positif.entities.*;
import fr.positif.utils.Astro;
import fr.positif.utils.Message;
import fr.positif.dao.*;

import java.io.IOException;
import java.util.*;

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


    public static Person checkCredentials(String email, String password) {
        JpaUtil.createEntityManager();

        Person person = PersonDao.getPersonByCred(email, password);

        JpaUtil.closeEntityManager();

        return person;
    }

    public static List<Prediction> generatePredictions(Consultation consultation, int loveLevel, int healthLevel, int workLevel) {
        List<Prediction> predictions = new ArrayList<>();
        Astro astro = new Astro();

        try {
            List<String> results = astro.getPredictions(consultation.getClient().getColor(), consultation.getClient().getAnimal(), loveLevel, healthLevel, workLevel);

            predictions.add(new Prediction(PredictionType.LOVE, loveLevel, results.get(0)));
            predictions.add(new Prediction(PredictionType.HEALTH, healthLevel, results.get(1)));
            predictions.add(new Prediction(PredictionType.WORK, workLevel, results.get(2)));

        } catch (IOException ex) {
            // TODO
        }

        return predictions;
    }

    public static boolean registerClient(Client client) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        boolean status = false;

        try {

            if(PersonDao.isEmailTaken(client.getEmail())){
                throw new Exception("Email address already taken.");
            }

            ServicesUtils.validateAndGenerateGpsAddress(client.getAddress());
            ServicesUtils.generateAstralProfile(client);
            ClientDao.persist(client);

            JpaUtil.validateTransaction();

            Message.envoyerMail("noreply@positif.fr", client.getEmail(), "Enregistrement ok", "Enregistrement correctement effectué.");
            status = true;
        } catch (Exception e) {
            JpaUtil.cancelTransaction();
            Message.envoyerMail("noreply@positif.fr", client.getEmail(), "Erreur lors de l'enregistrement", "Enregistrement ne s'est pas correctement effectué.");

            System.out.println(e);
        }

        JpaUtil.closeEntityManager();

        return status;
    }



    public static boolean initConsultation(Client client, Medium medium) {
        boolean status = false;

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        Employee employee = EmployeeDao.getEmployeeForConsultation(medium.getExperienceRequired(), medium.getVoiceType());

        if (employee != null) {
            Consultation consultation = new Consultation(client, medium, employee);

            consultation.setCreatedAt(new Date());
            ConsultationDao.persist(consultation);
            JpaUtil.validateTransaction();

            Message.envoyerMail("noreply@positif.fr", employee.getEmail(), "Nouvelle consultation", client.getLastname() + " " + client.getFirstname() + " veut une consultation avec " + medium.getName());
            status = true;

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
        ConsultationDao.update(consultation);

        Message.envoyerMail("noreply@positif.fr", consultation.getClient().getEmail(), "Consultation prete", "Votre consultation est prete, appelez le 06 54 23 89 98.");

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static void closeConsultation(Consultation consultation, String comment, Date closedAt) {
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        consultation.setClosedAt(closedAt);
        consultation.setComment(comment);
        consultation.setState(ConsultationStateType.CLOSED);
        ConsultationDao.update(consultation);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }

    public static Consultation getCurrentConsultation(Employee employee) {
        JpaUtil.createEntityManager();

        Consultation consultation = ConsultationDao.getCurrentConsultationByEmployee(employee);

        JpaUtil.closeEntityManager();

        return consultation;
    }

    // TODO: Implement pagination
    public static List<Consultation> getConsultations(Integer pageNumber, Integer pageSize, Client client) {
        JpaUtil.createEntityManager();

        List<Consultation> consultations = ConsultationDao.getConsultations(client);

        JpaUtil.closeEntityManager();

        return consultations;
    }

    // TODO: Implement pagination
    public static List<Consultation> getConsultations(Integer pageNumber, Integer pageSize, Employee employee) {
        JpaUtil.createEntityManager();

        List<Consultation> consultations = ConsultationDao.getConsultations(employee);

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
        ConsultationDao.update(consultation);

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


    public static Map<Integer, Long> getConsultationCountPerDay(){
        JpaUtil.createEntityManager();

        Map<Integer, Long> counts = EmployeeDao.getConsultationCountPerDay();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<ConsultationStateType, Long> getConsultationCountByStatus(){
        JpaUtil.createEntityManager();

        Map<ConsultationStateType, Long> counts = EmployeeDao.getConsultationCountByStatus();

        JpaUtil.closeEntityManager();

        return counts;
    }
    

    public static Map<Employee, Long> getClientCountByEmployee(){
        JpaUtil.createEntityManager();

        Map<Employee, Long> counts = EmployeeDao.getClientCountByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Employee, Medium> getFavoriteMediumByEmployee(){
        JpaUtil.createEntityManager();

        Map<Employee, Medium> counts = EmployeeDao.getFavoriteMediumByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Employee, Double> getConsultationTimeAverageByEmployee(){
        JpaUtil.createEntityManager();

        Map<Employee, Double> counts = EmployeeDao.getConsultationTimeAverageByEmployee();

        JpaUtil.closeEntityManager();

        return counts;
    }

    public static Map<Employee, Long> getConsultationCountByEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
