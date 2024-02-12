package org.centrale.api.controller.service;


import jakarta.persistence.*;

@Entity
@Table(name = "Players")
public class Players {


    @Id
    private Integer ID;


    private String Name;


    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
