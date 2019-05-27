/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.bxx.positif.dao;

import com.ifa.bxx.positif.Client;
import javax.persistence.EntityManager;

/**
 *
 * @author cthomasset
 */
public class ClientDao extends JpaUtil{
    
    public static void persists(Client client){

        EntityManager em = JpaUtil.obtenirEntityManager();
        
        em.persist(client);
        

    }
    
}
