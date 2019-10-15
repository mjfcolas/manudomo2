package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.data.dao.interfaces.EdfIndexDao;
import com.manu.manudomo2.restapi.data.entities.EdfIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class EdfIndexDaoImpl extends GenericDaoImpl<EdfIndex> implements EdfIndexDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EdfIndexDaoImpl.class);

    @Override
    public EdfIndex getFirstIndex(EdfPrice price) {
        String jpqlQuery = "SELECT x from EdfIndex x WHERE x.type=:type ORDER BY x.date ASC";
        TypedQuery<EdfIndex> query = this.getSession().createQuery(jpqlQuery, EdfIndex.class);
        query.setMaxResults(1);
        query.setParameter("type", price.getType());
        return query.getSingleResult();
    }

    @Override
    public EdfIndex getLastIndex(EdfPrice price) {
        String jpqlQuery = "SELECT x from EdfIndex x WHERE x.type=:type ORDER BY x.date DESC";
        TypedQuery<EdfIndex> query = this.getSession().createQuery(jpqlQuery, EdfIndex.class);
        query.setMaxResults(1);
        query.setParameter("type", price.getType());
        return query.getSingleResult();
    }

    @Override
    public EdfIndex getLastEdfIndexBeforeDate(Date date, EdfPrice price) {
        String jpqlQuery = "SELECT x from EdfIndex x WHERE x.date < :date AND x.type=:type ORDER BY x.date DESC";
        TypedQuery<EdfIndex> query = this.getSession().createQuery(jpqlQuery, EdfIndex.class);
        query.setMaxResults(1);
        query.setParameter("date", date);
        query.setParameter("type", price.getType());
        return query.getSingleResult();
    }

    @Override
    public EdfIndex getFirstEdfIndexAfterDate(Date date, EdfPrice price) {
        String jpqlQuery = "SELECT x from EdfIndex x WHERE x.date > :date AND x.type=:type ORDER BY x.date ASC";
        TypedQuery<EdfIndex> query = this.getSession().createQuery(jpqlQuery, EdfIndex.class);
        query.setMaxResults(1);
        query.setParameter("date", date);
        query.setParameter("type", price.getType());
        return query.getSingleResult();
    }

    @Override
    public List<EdfIndex> getEdfIndexBetweenDatesForGivenType(Date fromDate, Date toDate, Integer type) {
        LOGGER.debug("IN - EdfIndexDaoImpl.getEdfIndexBetweenDatesForGivenType - fromDate: {} - toDate {}", fromDate, toDate);

        String jpqlQuery = "SELECT x from EdfIndex x WHERE x.date >= :fromDate AND x.date <= :toDate AND x.type = :type ORDER BY date ASC";

        TypedQuery<EdfIndex> query = this.getSession().createQuery(jpqlQuery, EdfIndex.class);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        query.setParameter("type", type);

        return query.getResultList();
    }
}
