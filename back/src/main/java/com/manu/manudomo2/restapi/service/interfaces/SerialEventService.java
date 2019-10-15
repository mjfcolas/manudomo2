package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.data.entities.SerialEvent;

import java.util.Date;
import java.util.List;

public interface SerialEventService {

    /**
     * Récupération des erreurs comprises entre deux dates
     * Si une date est null, elle n'est pas prise en compte
     *
     * @param fromDate borne inférieure
     * @param toDate   borne supérieure
     */
    List<SerialEvent> getSerialEventBetweenDates(Date fromDate, Date toDate);

}
