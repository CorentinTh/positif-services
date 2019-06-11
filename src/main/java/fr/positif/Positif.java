/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif;

import fr.positif.dao.JpaUtil;
import fr.positif.entities.Medium;
import fr.positif.services.Services;
import fr.positif.services.ServicesInit;

import java.util.List;

/**
 * @author cthomasset
 */
public class Positif {
    public static void main(String[] args) {

        JpaUtil.init();
        System.out.println("\n\n\n");

        // --------------< Demo

        ServicesInit.insertMediums();

//        Demo.registerClientOk();
//        Demo.registerClientFailed();
//        Demo.loginClientOk();
//        Demo.loginClientFailed();
//        Demo.checkClientProfile();
//        Demo.checkMediumList();
//        Demo.getMediumInfo();
//        Demo.createConsultation();
//        Demo.acceptConsultation();
//        Demo.closeConsultation();
//        Demo.getStatistics();


        List<Medium> mediums = Services.getMediums(1, 1000);

        for (Medium m : mediums){
            System.out.println("{" +
                    "id: " + m.getId() + ", " +
                    "name: \"" + m.getName() + "\", " +
                    "talent: \"" + m.getTalent() + "\", " +
                    "description: \"" + m.getDescription() + "\" " +
                    "},");
        }

        // --------------> Demo

        System.out.println("\n\n\n");
        JpaUtil.destroy();
    }
}
