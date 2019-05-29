/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.ExperienceType;
import com.ifa.b03.positif.entities.Person;
import com.ifa.b03.positif.entities.VoiceType;

/**
 *
 * @author cthomasset
 */
public class PersonDao {
    public static void persist(Person person){
        JpaUtil.getEntityManager().persist(person);
    }
}
