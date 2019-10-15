package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.PressureDao;
import com.manu.manudomo2.restapi.data.entities.Pressure;
import org.springframework.stereotype.Repository;

@Repository
public class PressureDaoImpl extends GenericDaoImpl<Pressure> implements PressureDao {
}
