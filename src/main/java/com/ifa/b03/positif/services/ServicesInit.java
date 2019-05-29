/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.services;

import com.ifa.b03.positif.dao.JpaUtil;
import com.ifa.b03.positif.dao.PersonDao;
import com.ifa.b03.positif.entities.Employee;
import com.ifa.b03.positif.entities.ExperienceType;
import com.ifa.b03.positif.entities.VoiceType;
import java.util.Date;

/**
 *
 * @author cthomasset
 */
public class ServicesInit {
    public static void insertEmployee(){
        JpaUtil.createEntityManager();
        JpaUtil.openTransaction();
        
        PersonDao.persist(new Employee(VoiceType.Masculine, ExperienceType.Senior, "test@mail.com", "firstname", "lastname", "M", "password", new Date()));
        
        JpaUtil.validateTransaction();
        JpaUtil.closeEntityManager();
    }
    
    public static void insertMedium(){
        
    }
}
