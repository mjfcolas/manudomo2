package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "edf_index_seq")
public class EdfIndex extends ValuableEntity<Integer> implements TypableEntity {

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
