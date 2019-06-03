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
 * @author cthomasset
 */
public class PersonDao {
    public static void persist(Person person) {
        JpaUtil.getEntityManager().persist(person);
    }

    public static Person getPersonByCred(String email, String password) {
        try {
            return (Person) JpaUtil
                    .getEntityManager()
                    .createQuery("select p from Person p where p.email = :email and p.password = :password")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    public static Person getPersonByID(Long personID) {
        try {
            return JpaUtil.getEntityManager().find(Person.class, personID);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isEmailTaken(String email) {
        return !(((Long) JpaUtil.getEntityManager()
                .createQuery("select count(p) from Person p where p.email = :email")
                .setParameter("email", email)
                .getSingleResult()) == 0);
    }
}
