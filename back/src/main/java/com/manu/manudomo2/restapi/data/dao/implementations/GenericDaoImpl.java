package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

public abstract class GenericDaoImpl<E> implements GenericDao<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);

    @Autowired
    protected SessionFactory sessionFactory;

    private final Class<E> entityClass;

    public GenericDaoImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void save(E entity) {
        getSession().saveOrUpdate(entity);
    }

    public E getLastEntityForGivenType(Integer type) {
        String jpqlQuery;
        if (type != null) {
            jpqlQuery = "SELECT x from " + entityClass.getSimpleName() + " x WHERE x.type = :type ORDER BY x.date DESC";
        } else {
            jpqlQuery = "SELECT x from " + entityClass.getSimpleName() + " x ORDER BY x.date DESC";
        }
        TypedQuery<E> query = this.getSession().createQuery(jpqlQuery, entityClass);
        query.setMaxResults(1);
        if (type != null) {
            query.setParameter("type", type);
        }

        return query.getSingleResult();
    }

    public List<E> getEntityBetweenDates(Date fromDate, Date toDate){
        LOGGER.debug("IN - fromDate: {} - toDate {}", fromDate, toDate);
        String jpqlQuery = "SELECT x from " + entityClass.getSimpleName() + " x WHERE x.date >= :fromDate AND x.date <= :toDate ORDER BY x.date DESC";
        TypedQuery<E> query = this.getSession().createQuery(jpqlQuery, entityClass);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        return query.getResultList();
    }

    public List<E> findAll(){
        String jpqlQuery = "SELECT x from " + entityClass.getSimpleName() + " x";
        TypedQuery<E> query = this.getSession().createQuery(jpqlQuery, entityClass);
        return query.getResultList();
    }
}
