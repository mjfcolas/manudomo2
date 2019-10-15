package com.manu.manudomo2.restapi.data.dao.implementations;

import com.manu.manudomo2.restapi.data.dao.interfaces.HygroDao;
import com.manu.manudomo2.restapi.data.entities.Hygro;
import org.springframework.stereotype.Repository;

@Repository
public class HygroDaoImpl extends GenericDaoImpl<Hygro> implements HygroDao {
}
