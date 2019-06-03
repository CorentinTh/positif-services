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
 * @author cthomasset
 */
public class Positif {
    public static void main(String[] args) {

        JpaUtil.init();
        System.out.println("\n\n\n");

        // --------------< Demo

//        Demo.registerClientOk();
//        Demo.registerClientFailed();
//        Demo.checkClientProfile();
//        Demo.checkMediumList();
//        Demo.getMediumInfo();
        Demo.createConsultation();

        // --------------> Demo

        System.out.println("\n\n\n");
        JpaUtil.destroy();
    }
}
