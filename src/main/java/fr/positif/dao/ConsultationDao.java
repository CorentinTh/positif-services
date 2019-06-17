/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.dao;

import fr.positif.entities.Client;
import fr.positif.entities.Consultation;
import fr.positif.entities.ConsultationStateType;
import fr.positif.entities.Employee;

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
                    .createQuery("select c from Consultation c where c.employee.id = :employeeID AND (c.state = :state1 OR c.state = :state2)")
                    .setParameter("employeeID", employee.getId())
                    .setParameter("state1", ConsultationStateType.PENDING)
                    .setParameter("state2", ConsultationStateType.WAITING_VALIDATION)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }


    public static List<Consultation> getCurrentConsultationByClient(Client client) {
        try {

            return (List<Consultation>) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Consultation c where c.client.id = :clientID and c.state = :state")
                    .setParameter("clientID", client.getId())
                    .setParameter("state", ConsultationStateType.PENDING)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public static void update(Consultation consultation){
        JpaUtil.getEntityManager().merge(consultation);
    }

    public static List<Consultation> getConsultations(Client client){
        try{
            return (List<Consultation>) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Consultation c where c.client.id = :clientID")
                    .setParameter("clientID", client.getId())
                    .getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public static List<Consultation> getConsultations(Employee employee){
        try{
            return (List<Consultation>) JpaUtil
                    .getEntityManager()
                    .createQuery("select c from Consultation c where c.employee.id = :employeeID")
                    .setParameter("employeeID", employee.getId())
                    .getResultList();
        }catch (Exception e){
            return null;
        }
    }
}
