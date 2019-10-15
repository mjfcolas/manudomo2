package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.data.entities.Temperature;

import java.util.Date;
import java.util.List;

public interface TemperatureService {

    /**
     * Récupération des températures comprises entre deux dates
     * Si une date est null, elle n'est pas prise en compte
     * @param fromDate borne inférieure
     * @param toDate borne supérieure
     * @return Liste des températures entre les bornes données
     */
    List<Temperature> getTemperatureBetweenDates(Date fromDate, Date toDate, TemperatureType type);

    /**
     * Récupère la dernière mesure de température en base
     * @return
     */
    Temperature getLastTemperature(TemperatureType type);
}
