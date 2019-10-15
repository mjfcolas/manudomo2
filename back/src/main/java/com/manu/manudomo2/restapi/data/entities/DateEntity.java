package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class DateEntity extends IdEntity {
    protected Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
