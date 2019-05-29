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
 *
 * @author cthomasset
 */
public class Services {
    
    private static void generateAstralProfil(Client client){
        Astro astro = new Astro();
        List<String> profil;
        
        try {
            profil = astro.getProfil(client.getFirstname(), client.getBirthDate());
            
            client.setZodiacSign(profil.get(0));
            client.setChineseSign(profil.get(1));
            client.setColor(profil.get(2));
            client.setAnimal(profil.get(3));

        } catch (IOException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void checkCredentials(String email, String password){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        // TODO add select user by creds in PersonDao
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
    
    public static List<Prediction> generatePredictions(Consultation consultation, int loveLevel, int healthLevel, int workLevel){
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
    
    private static void validateAndGenerateGpsAddress(Address address){
        // TODO
    }
    
    public static void registerClient(Client client){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
                
        try {
            Services.validateAndGenerateGpsAddress(client.getAddress());
            Services.generateAstralProfil(client);
            ClientDao.persist(client);

            JpaUtil.validateTransaction();
        } catch (Exception e) {
            JpaUtil.cancelTransaction();
        }
        
        JpaUtil.closeEntityManager();
    }
   
    
    public static void listMedium(int offset, int count){
        JpaUtil.createEntityManager();
        
        JpaUtil.closeEntityManager();
    }
    
    public static void listClients(int offset, int count){
        JpaUtil.createEntityManager();
        
        JpaUtil.closeEntityManager();
    }
    
    public static Client getInfoClient(Long clientID){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        Client client = ClientDao.getClientById(clientID);
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
        
        return client;
    }
    
    public static void initConsultation(Client client, Medium medium){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        Employee employee = EmployeeDao.getEmployeeForConsultation(medium.getExperienceRequired(), medium.getVoiceType());       
        Consultation consultation = new Consultation(client, medium, employee);
        
        ConsultationDao.persist(consultation);
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
        
        // Notif => Employé
        // TODO if employee is null pas créer consultation, renvoyer erreur
    }
    
    public static void acceptConsultation(Consultation consultation, List<Prediction> predictions){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        consultation.setAnsweredAt(new Date());       
        consultation.setPredictions(predictions);
        
        PredictionDao.persist(predictions);
        ConsultationDao.persist(consultation);
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
        
        // Notification client
    }
    
    public static void closeConsultation(Consultation consultation, String comment, Date closedAt){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        consultation.setClosedAt(closedAt);
        consultation.setComment(comment);
        
        ConsultationDao.persist(consultation);
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
    
}
