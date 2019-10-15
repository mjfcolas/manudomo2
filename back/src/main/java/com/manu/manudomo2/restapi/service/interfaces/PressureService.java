package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.data.entities.Pressure;

import java.util.Date;
import java.util.List;

public interface PressureService {

    /**
     * Get Pressure list between dates
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Pressure> getPressureBetweenDates(Date fromDate, Date toDate);
}
