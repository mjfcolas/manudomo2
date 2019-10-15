package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.data.entities.Intensity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;

public class IntensityVm {
    protected Date date;
    protected String value;

    protected DecimalFormat df = new DecimalFormat("#.0");
    protected DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();

    public IntensityVm(Intensity intensity) {

        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        this.setDate(intensity.getDate());
        this.setValue(intensity.getValue());
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
        this.value = df.format(value);
    }
}
