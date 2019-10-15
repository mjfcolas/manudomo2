package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@SequenceGenerator(name = "idgen", sequenceName = "temp_chauff_seq")
@Table(name = "temp_chauff")
public class TempChauff extends DateEntity {

    private Integer temp;
    @Column(name="start_hour")
    private Date startHour;
    @Column(name="end_hour")
    private Date endHour;

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(final Integer temp) {
        this.temp = temp;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(final Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(final Date endHour) {
        this.endHour = endHour;
    }
}
