package com.manu.manudomo2.restapi.data.dao.interfaces;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.data.entities.EdfIndex;

import java.util.Date;
import java.util.List;

public interface EdfIndexDao extends GenericDao<EdfIndex> {
    EdfIndex getFirstIndex(EdfPrice price);

    EdfIndex getLastIndex(EdfPrice price);

    EdfIndex getLastEdfIndexBeforeDate(Date date, EdfPrice price);

    EdfIndex getFirstEdfIndexAfterDate(Date date, EdfPrice price);

    List<EdfIndex> getEdfIndexBetweenDatesForGivenType(Date fromDate, Date toDate, Integer type);
}
