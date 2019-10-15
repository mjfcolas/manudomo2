package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.config.AppConfig;
import com.manu.manudomo2.restapi.data.entities.Hygro;

import java.util.Date;

/**
 * Represent displayables temperature points
 *
 * @author emmanuel
 */
public class HygroVm {

    private Date date;
    private String value;

    public HygroVm(Hygro hygro) {
        this.setDate(hygro.getDate());
        this.setValue(hygro.getValue()
        );
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