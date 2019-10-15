package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.data.dao.interfaces.PressureDao;
import com.manu.manudomo2.restapi.data.entities.Pressure;
import com.manu.manudomo2.restapi.service.interfaces.PressureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PressureServiceImpl implements PressureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PressureServiceImpl.class);
    @Autowired
    private PressureDao pressureDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pressure> getPressureBetweenDates(Date fromDate, Date toDate) {
        LOGGER.debug("IN - TemperatureServiceImpl.getPressureBetweenDates -fromDate: {} - toDate {}", fromDate, toDate);
        //Hack to avoid pressure saved with inconsistent values
        return pressureDao.getEntityBetweenDates(fromDate, toDate).stream().filter(x -> x.getValueRel() > 900).collect(Collectors.toList());
    }
}
