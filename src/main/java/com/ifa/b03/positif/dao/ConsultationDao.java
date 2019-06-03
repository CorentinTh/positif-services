/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Client;
import com.ifa.b03.positif.entities.Consultation;
import com.ifa.b03.positif.entities.ConsultationStateType;
import com.ifa.b03.positif.entities.Employee;

import java.util.List;


/**
 * @author cthomasset
 */
public class ConsultationDao {
    static public void persist(Consultation consultation) {
        JpaUtil.getEntityManager().persist(consultation);
    }

    public static Consultation getConsultationById(Long consultationID) {
        try {
            return JpaUtil.getEntityManager().find(Consultation.class, consultationID);
        } catch (Exception e) {
            return null;
        }
    }

    public static Consultation getCurrentConsultationByEmployee(Employee employee) {
        try {
            return (Consultation) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Consultation c where c.employee.id = :employeeID AND c.state = :state")
                    .setParameter("employeeID", employee.getId())
                    .setParameter("state", ConsultationStateType.PENDING)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    public static List<Consultation> getConsultationsByClient(Client client) {
        try {

            return (List<Consultation>) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Consultation c where c.client.id = :clientID")
                    .setParameter("clientID", client.getId())
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
