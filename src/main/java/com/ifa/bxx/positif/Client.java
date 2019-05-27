/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifa.bxx.positif;

import javax.persistence.*;

/**
 *
 * @author cthomasset
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }

    public Client(String name) {
        this.name = name;
    }

    protected Client() {
    }
    
}
