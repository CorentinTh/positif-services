/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif;

import com.ifa.b03.positif.dao.JpaUtil;
import com.ifa.b03.positif.dao.PersonDao;
import com.ifa.b03.positif.services.Services;
import com.ifa.b03.positif.services.ServicesInit;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author cthomasset
 */
public class Positif {
    public static void main (String[] args){
        System.out.println("Hello World");

        JpaUtil.init();

        ServicesInit.insertEmployees();


        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();

        System.out.println(PersonDao.getPersonByCred("ct@example.com", "ctsqd"));

        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();




        JpaUtil.destroy();
    }
}
