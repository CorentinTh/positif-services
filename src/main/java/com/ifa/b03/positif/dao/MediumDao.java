package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Medium;

import java.util.List;

public class MediumDao {
    static public Medium getMediumByID(Long id) {
        try {
            return JpaUtil.getEntityManager().find(Medium.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    static public List<Medium> getMediums(int pageNumber, int pageSize) {

        try {
            return (List<Medium>) JpaUtil
                    .getEntityManager()
                    .createQuery("select m from Medium m")
                    .setFirstResult((pageNumber - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public static void persist(Medium medium) {
        JpaUtil.getEntityManager().persist(medium);
    }
}
