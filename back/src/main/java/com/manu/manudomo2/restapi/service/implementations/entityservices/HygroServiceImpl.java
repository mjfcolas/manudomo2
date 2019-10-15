package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.data.dao.interfaces.HygroDao;
import com.manu.manudomo2.restapi.data.entities.Hygro;
import com.manu.manudomo2.restapi.service.interfaces.HygroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HygroServiceImpl implements HygroService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HygroServiceImpl.class);
    @Autowired
    private HygroDao hygroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hygro> getHygroBetweenDates(Date fromDate, Date toDate) {
        LOGGER.debug("IN - HygroServiceImpl.getPressureBetweenDates -fromDate: {} - toDate {}", fromDate, toDate);
        return hygroDao.getEntityBetweenDates(fromDate, toDate);
    }

}
