package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "temperature_seq")
public class Temperature extends ValuableEntity<Double> implements TypableEntity {

    protected Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
