package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="idgen")
    protected int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
