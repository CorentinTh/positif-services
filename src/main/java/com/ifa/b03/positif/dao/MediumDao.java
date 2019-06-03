package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediumDao {
    static public Medium getMediumByID(Long id) {
        try {
            return JpaUtil.getEntityManager().find(Medium.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    static public List<Medium> getMediums(int pageNumber, int pageSize) {
        pageNumber = pageNumber < 1 ? 1 : pageNumber;


        try {
            return (List<Medium>) JpaUtil
                    .getEntityManager()
                    .createQuery("select m from Medium m")
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static void persist(Medium medium) {
        JpaUtil.getEntityManager().persist(medium);
    }


    public static Map<Medium, Long> getClientCountByMedium() {
        try {

            Map<Medium, Long> map = new HashMap<Medium, Long>();

            List<Object[]> results = JpaUtil
                    .getEntityManager()
                    .createQuery("select me, count(cl) from Consultation co join Client cl, Medium me group by me")
                    .getResultList();

            for (Object[] tuple : results){
                map.put((Medium) tuple[0], (Long) tuple[1]);
            }

            return map;

        } catch (Exception e) {
            return null;
        }
    }

    public static Map<Medium, Double> getConsultationTimeAverageByMedium() {
        return null; // TODO: getConsultationTimeAverageByMedium
    }

    public static Map<Medium, List<Long>> getClientCountByMediumPerDay() {
        return null; // TODO: getClientCountByMediumPerDay
    }
}
