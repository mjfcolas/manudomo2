package com.manu.manudomo2.restapi.data.dao.interfaces;

import java.util.Date;
import java.util.List;

public interface GenericDao<E> {

    void save(E entity);

    E getLastEntityForGivenType(Integer type);

    List<E> getEntityBetweenDates(Date fromDate, Date toDate);

    List<E> findAll();
}
