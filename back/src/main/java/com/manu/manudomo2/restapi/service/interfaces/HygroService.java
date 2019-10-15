package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.data.entities.Hygro;

import java.util.Date;
import java.util.List;

public interface HygroService {
    /**
     * Get hygrometrie between dates
     * @param fromDate
     * @param toDate
     * @return
     */
    List<Hygro> getHygroBetweenDates(Date fromDate, Date toDate);
}
