package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "pression_seq")
@Table(name = "pression")
// TODO should be valuable typable, but must refactor column names
public class Pressure extends DateEntity {
    private Double valueAbs;
    private Double valueRel;

    public Double getValueAbs() {
        return valueAbs;
    }

    public void setValueAbs(final Double valueAbs) {
        this.valueAbs = valueAbs;
    }

    public Double getValueRel() {
        return valueRel;
    }

    public void setValueRel(final Double valueRel) {
        this.valueRel = valueRel;
    }
}
