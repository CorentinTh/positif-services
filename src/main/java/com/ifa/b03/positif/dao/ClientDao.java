/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Client;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author cthomasset
 */
public class ClientDao{
   
    
    public static Client getClientById(Long id){
        try {
            return (Client) JpaUtil
                    .getEntityManager()
                    .find(Client.class, id);
        }catch (Exception e){
            return null;
        }

    }
    
    public static void persist(Client client){
        JpaUtil.getEntityManager().persist(client);
    }


    public static List<Client> getClients(int pageNumber, int pageSize) {
        try{
            return (List<Client>) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Client c")
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

        }catch (Exception e){
            return null;
        }
    }
}
