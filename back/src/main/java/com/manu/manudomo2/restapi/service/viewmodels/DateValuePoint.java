package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.config.AppConfig;

import java.util.Date;

public class DateValuePoint {
    private Date date;
    private String value;

    public DateValuePoint(Date date, String value) {
        this.setDate(date);
        this.value = value;
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
