package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "mode_chauff_seq")
@Table(name = "mode_chauff")
public class ModeChauff extends DateEntity {

    private Boolean hourMode;

    public Boolean getHourMode() {
        return hourMode;
    }

    public void setHourMode(final Boolean hourMode) {
        this.hourMode = hourMode;
    }
}
