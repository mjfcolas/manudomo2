package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.TemperatureDao;
import com.manu.manudomo2.restapi.data.entities.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class TemperatureDaoImpl extends GenericDaoImpl<Temperature> implements TemperatureDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureDaoImpl.class);

    public List<Temperature> getTemperatureBetweenDatesForGivenType(Date fromDate, Date toDate, Integer type) {
        LOGGER.debug("IN - TemperatureDaoImpl.getTemperatureBetweenDatesForGivenType - fromDate: {} - toDate {}", fromDate, toDate);

        String jpqlQuery = "SELECT temp from Temperature temp WHERE temp.date >= :fromDate AND temp.date <= :toDate AND temp.type = :type";

        TypedQuery<Temperature> query = this.getSession().createQuery(jpqlQuery, Temperature.class);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        query.setParameter("type", type);

        return query.getResultList();
    }
}
