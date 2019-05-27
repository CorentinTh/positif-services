/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.b03.positif.entities;

import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Client extends Person{

    public Client() {
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(String zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    public String getChineseSign() {
        return chineseSign;
    }

    public void setChineseSign(String chineseSign) {
        this.chineseSign = chineseSign;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    private String zodiacSign;
    private String chineseSign;
    private String color;
    private String animal;
}
