package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.config.AppConfig;
import com.manu.manudomo2.restapi.data.entities.Pressure;

import java.util.Date;

/**
 * Represent displayables temperature points
 *
 * @author emmanuel
 */
public class PressureVm {

    private Date date;
    private String value;

    public PressureVm(Pressure pressure) {
        this.setDate(pressure.getDate());
        this.setValue(pressure.getValueRel());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = AppConfig.df.format(value);
    }

}