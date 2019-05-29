/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

/**
 *
 * @author cthomasset
 */
public enum PredictionType {
    LOVE,
    HEALTH,
    WORK;

    public static PredictionType fromInt(int id){
        switch(id){
            case 0: return LOVE;
            case 1: return HEALTH;
            case 2: return WORK;
            default: return LOVE;
        }
    }
    
    
}
