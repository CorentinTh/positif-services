package com.ifa.b03.positif.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToMany(mappedBy="medium")
    private List<Consultation> consultations ;

    public String getId() {
        return id;
    }

    public Medium() {
    }


}
