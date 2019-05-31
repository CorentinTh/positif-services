/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif;

import com.ifa.b03.positif.entities.Client;
import com.ifa.b03.positif.dao.ClientDao;
import com.ifa.b03.positif.dao.JpaUtil;
import com.ifa.b03.positif.dao.PersonDao;
import com.ifa.b03.positif.services.Services;
import com.ifa.b03.positif.services.ServicesInit;

/**
 *
 * @author cthomasset
 */
public class Positif {
    public static void main (String[] args){
        System.out.println("Hello World");

        JpaUtil.init();

        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        Client c = new Client();
        c.setFirstname("Bob");  
        PersonDao.persist(c);

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
        
        System.out.println(Services.getInfoClient(1L).getFirstname());

        ServicesInit.insertEmployee();
        
        JpaUtil.destroy();
    }
}
