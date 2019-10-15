package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.data.entities.EdfIndex;

import java.util.Date;

public class EdfIndexVm {
    private Date date;
    private String value;

    public EdfIndexVm(EdfIndex edfIndex) {
        this.setDate(edfIndex.getDate());
        this.setValue(edfIndex.getValue());
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

    public void setValue(Integer value) {
        this.value = String.valueOf(value);
    }
}
