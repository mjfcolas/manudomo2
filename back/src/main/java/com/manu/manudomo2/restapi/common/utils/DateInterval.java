package com.manu.manudomo2.restapi.common.utils;

import com.manu.manudomo2.restapi.config.AppConfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInterval {
    private Date fromDate;

    private Date toDate;

    public DateInterval(String startTime, String endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat(AppConfig.prop().getProperty("manudomo2.dateformat"));

        if (startTime != null) {
            try {
                this.fromDate = formatter.parse(startTime);
            } catch (ParseException e) {
                this.fromDate = null;
            }
        }

        if (endTime != null) {
            try {
                this.toDate = formatter.parse(endTime);
            } catch (ParseException e) {
                this.toDate = null;
            }
        }
    }

    public DateInterval(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(final Date toDate) {
        this.toDate = toDate;
    }

}
