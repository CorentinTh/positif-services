/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.dao;

import fr.positif.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cthomasset
 */
public class EmployeeDao {

    static public Employee getEmployeeForConsultation(ExperienceType experience, VoiceType voiceType) {

        // select employee which as no pending or waiting for validation consultations
        // and voice match
        // and experience match (senior employee can do junior or senior)
        // and the least amount of consultation
        String q = "select e from Employee e left outer join e.consultations c" +
                " where e.voiceType = :voiceType " +
                " and ((:experience = fr.positif.entities.ExperienceType.JUNIOR AND e.experience = :experience) or (:experience = fr.positif.entities.ExperienceType.SENIOR)) " +
                " and (size(e.consultations) = 0 or (c.state not in (fr.positif.entities.ConsultationStateType.PENDING, fr.positif.entities.ConsultationStateType.WAITING_VALIDATION)))" +
                " order by size(e.consultations)";




        try {

            List<Employee> employees = (List<Employee>) JpaUtil
                    .getEntityManager()
                    .createQuery(q)
                    .setParameter("voiceType", voiceType)
                    .setParameter("experience", experience)
                    .getResultList();

            System.out.println(employees);
            return employees.get(0);

//            for (Employee e : employees) {
//
//
//                Consultation c = e.getConsultations().get(0);
//
//                if (c == null || c.getClosedAt() != null) {
//                    return e;
//                }
//            }

        } catch (Exception e) {
            return null;
        }

//
//        try{
//            // TODO: tester le "<="
//            List<Employee> employees = (List<Employee>) JpaUtil
//                    .getEntityManager()
//                    .createQuery("select e from Employee e where e.voiceType = :voiceType and e.experience = :experience order by size(e.consultations)")
//                    .setParameter("voiceType", voiceType)
//                    .setParameter("experience", experience)
//                    .getSingleResult();
//
//            for(Employee e : employees ){
//                Consultation c = e.getConsultations().get(0);
//
//                if(c == null || c.getClosedAt()!= null){
//                    return e;
//                }
//            }
//
//        }catch(Exception e){
//            return null;
//        }
//        return null;
    }
    
    public static Map<Employee, Long> getClientCountByEmployee() {
        try {
            final List<Object[]> resultList = JpaUtil
                    .getEntityManager()
                    .createQuery("select e, count(distinct cl) from Employee e inner join Consultation c inner join Client cl group by e")
                    .getResultList();

            return getEmployeeCountMapFromResultList(resultList);
        } catch (Exception e) {
            return null;
        }
    } //TODO: Test

    public static Map<Employee, Long> getConsultationCountByEmployee() {
        try {
            final List<Object[]> resultList = JpaUtil
                    .getEntityManager()
                    .createQuery("select e, count(c) from Employee e inner join Consultation c group by e")
                    .getResultList();

            return getEmployeeCountMapFromResultList(resultList);
        } catch (Exception e) {
            return null;
        }
    } //TODO: Test

    private static Map<Employee, Long> getEmployeeCountMapFromResultList(List<Object[]> resultList) {
        Map<Employee, Long> resultMap = new HashMap<>();
        for (Object[] result : resultList) {
            resultMap.put((Employee) result[0], (Long) result[1]);
        }

        return resultMap;
    }

    public static Map<Employee, Medium> getFavoriteMediumByEmployee() {
        return null; // TODO
    }

    public static Map<Employee, Double> getConsultationTimeAverageByEmployee() {
        return null; // TODO
    }
}
