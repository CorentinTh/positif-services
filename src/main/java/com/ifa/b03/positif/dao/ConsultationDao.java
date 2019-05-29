/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Consultation;

/**
 *
 * @author cthomasset
 */
public class ConsultationDao {
    static public void persist(Consultation consultation){
        JpaUtil.getEntityManager().persist(consultation);
    }
}
