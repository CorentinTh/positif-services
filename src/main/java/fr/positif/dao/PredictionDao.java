/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.positif.dao;

import fr.positif.entities.Prediction;
import java.util.List;

/**
 *
 * @author cthomasset
 */
public class PredictionDao {
    static public void persist(Prediction prediction){
         JpaUtil.getEntityManager().persist(prediction);
    }
    
    static public void persist(List<Prediction> predictions){
        for(Prediction p : predictions){
            PredictionDao.persist(p);
        }
    }
    
}
