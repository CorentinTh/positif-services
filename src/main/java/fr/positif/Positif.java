/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif;

import fr.positif.dao.JpaUtil;

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
//        Demo.createConsultation();
//        Demo.acceptConsultation();
        Demo.closeConsultation();

        // --------------> Demo

        System.out.println("\n\n\n");
        JpaUtil.destroy();
    }
}
