package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "idgen", sequenceName = "com_chauff_seq")
@Table(name = "com_chauff")
public class ComChauff extends DateEntity {

    private Boolean onoff;
    private boolean done;

    public Boolean getOnoff() {
        return onoff;
    }

    public void setOnoff(final Boolean onoff) {
        this.onoff = onoff;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }

}
