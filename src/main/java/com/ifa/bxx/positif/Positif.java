/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.bxx.positif;

import com.ifa.bxx.positif.dao.ClientDao;
import com.ifa.bxx.positif.dao.JpaUtil;

/**
 *
 * @author cthomasset
 */
public class Positif {
    public static void main (String[] args){
        System.out.println("Hello World");

        JpaUtil.init();
        JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();

        ClientDao.persists(new Client("Bob"));
        
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager();
        JpaUtil.destroy();
    }
}
