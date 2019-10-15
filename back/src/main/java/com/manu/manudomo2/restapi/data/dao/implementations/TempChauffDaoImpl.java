package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.TempChauffDao;
import com.manu.manudomo2.restapi.data.entities.TempChauff;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class TempChauffDaoImpl extends GenericDaoImpl<TempChauff> implements TempChauffDao {

    @Override
    public TempChauff getGlobalTemp() {
        String jpqlQuery = "SELECT x from TempChauff x WHERE x.startHour is null and x.endHour is null";
        TypedQuery<TempChauff> query = this.getSession().createQuery(jpqlQuery, TempChauff.class);
        return query.getSingleResult();
    }

    @Override
    public TempChauff getGlobalTempForStartHour(Date startHour) {
        String jpqlQuery = "SELECT x from TempChauff x WHERE x.startHour=:startHour";
        TypedQuery<TempChauff> query = this.getSession().createQuery(jpqlQuery, TempChauff.class);
        query.setParameter("startHour", startHour);
        return query.getSingleResult();
    }

    @Override
    public List<TempChauff> getCompleteProfile() {
        String jpqlQuery = "SELECT x from TempChauff x WHERE x.startHour IS NOT NULL";
        TypedQuery<TempChauff> query = this.getSession().createQuery(jpqlQuery, TempChauff.class);
        return query.getResultList();
    }
}
