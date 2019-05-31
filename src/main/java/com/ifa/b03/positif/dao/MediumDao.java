package com.ifa.b03.positif.dao;

import com.ifa.b03.positif.entities.Medium;

import java.util.List;

public class MediumDao {
    static public Medium getMediumByID(Long id) {
        return JpaUtil.getEntityManager().find(Medium.class, id);
    }

    static public List<Medium> getMediums(int pageNumber, int pageSize) {
        return (List<Medium>) JpaUtil
                .getEntityManager()
                .createQuery("select m from Medium m")
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
