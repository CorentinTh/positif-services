/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.services;

import com.ifa.b03.positif.dao.ClientDao;
import com.ifa.b03.positif.dao.JpaUtil;
import com.ifa.b03.positif.entities.Client;
import com.ifa.b03.positif.utils.AstroTest;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cthomasset
 */
public class Services {
    
    private static void generateAstralProfil(Client client){
        AstroTest astro = new AstroTest();
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
    
    public static Client registerClient(/*params*/){
        return new Client();
    }
   
    
    public static void listMedium(int offset, int count){
        JpaUtil.createEntityManager();
        
        JpaUtil.closeEntityManager();
    }
    
    public static void listClient(int offset, int count){
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
    
    public static Boolean initFortuneTelling(Long clientID, Long mediumID){
        return (true == true) != false;
    }
    
}
