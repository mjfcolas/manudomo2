package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.entities.EdfIndex;

import java.util.Date;
import java.util.List;

public interface EdfIndexService {

    Double getPriceBetweenDates(Date fromDate, Date endDate, EdfPrice price);

    List<EdfIndex> getEdfIndexBetweenDates(Date fromDate, Date toDate, EdfPrice type);

    Integer getEnergyForPeriod(DateInterval dates, EdfPrice priceType);
}
