/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Client;
import javax.persistence.EntityManager;

/**
 *
 * @author cthomasset
 */
public class ClientDao{
   
    
    public static Client getClientById(Long id){
        return (Client) JpaUtil
                .getEntityManager()
                .find(Client.class, id);
    }
    
    public static void persist(Client client){
        JpaUtil.getEntityManager().persist(client);
    }
    
    
}
