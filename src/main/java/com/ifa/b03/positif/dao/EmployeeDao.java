/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author cthomasset
 */
public class EmployeeDao {
    
    static public Employee getEmployeeForConsultation(ExperienceType experience, VoiceType voiceType){
        
        try{
            // TODO: tester le "<="
            List<Employee> employees = (List<Employee>) JpaUtil
                    .getEntityManager()
                    .createQuery("select e from Employee e where e.voiceType = :voiceType and e.experience = :experience order by size(e.consultations)")
                    .setParameter("voiceType", voiceType)
                    .setParameter("experience", experience)
                    .getSingleResult();

            for(Employee e : employees ){
                Consultation c = e.getConsultations().get(0);

                if(c == null || c.getClosedAt()!= null){
                    return e;
                }
            }

        }catch(Exception e){
            return null;
        }
        return null;
    }

    public static Map<Client, List<Long>> getClientCountByEmployeePerDay() {
        return null; // TODO: getClientCountByEmployeePerDay
    }

    public static Map<Client, Long> getClientCountByEmployee() {
        return null; // TODO: getClientCountByEmployee
    }

    public static Map<Client, Medium> getFavoriteMediumByEmployee() {
        return null; // TODO: getFavoriteMediumByEmployee
    }

    public static Map<Client, Double> getConsultationTimeAverageByEmployee() {
        return null; // TODO: getConsultationTimeAverageByEmployee
    }
}
