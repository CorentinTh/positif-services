/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Consultation;
import com.ifa.b03.positif.entities.Employee;
import com.ifa.b03.positif.entities.ExperienceType;
import com.ifa.b03.positif.entities.VoiceType;
import java.util.List;

/**
 *
 * @author cthomasset
 */
public class EmployeeDao {
    
    static public Employee getEmployeeForConsultation(ExperienceType experience, VoiceType voiceType){
        
        try{
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
    
}
