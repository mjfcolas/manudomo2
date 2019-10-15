package com.manu.manudomo2.restapi.data.dao.interfaces;

import com.manu.manudomo2.restapi.data.entities.Temperature;

import java.util.Date;
import java.util.List;

public interface TemperatureDao extends GenericDao<Temperature> {
    List<Temperature> getTemperatureBetweenDatesForGivenType(Date fromDate, Date toDate, Integer type);

}
