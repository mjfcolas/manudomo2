package com.manu.manudomo2.restapi.data.dao.interfaces;

import com.manu.manudomo2.restapi.data.entities.TempChauff;

import java.util.Date;
import java.util.List;

public interface TempChauffDao extends GenericDao<TempChauff> {
    TempChauff getGlobalTemp();
    TempChauff getGlobalTempForStartHour(Date startHour);
    List<TempChauff> getCompleteProfile();
}
