package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.data.dao.interfaces.TemperatureDao;
import com.manu.manudomo2.restapi.data.entities.Temperature;
import com.manu.manudomo2.restapi.service.interfaces.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureServiceImpl.class);
    @Autowired
    private TemperatureDao temperatureDao;

    @Override
    @Transactional(readOnly = true)
    public List<Temperature> getTemperatureBetweenDates(Date fromDate, Date toDate, TemperatureType type) {
        LOGGER.debug("IN - TemperatureServiceImpl.getTemperatureBetweenDates -fromDate: {} - toDate {} - type {}", fromDate, toDate, type);
        return temperatureDao.getTemperatureBetweenDatesForGivenType(fromDate, toDate, type.getType());
    }

    @Override
    @Transactional(readOnly = true)
    public Temperature getLastTemperature(TemperatureType type) {
        LOGGER.debug("IN - TemperatureServiceImpl.getLastTemperature - type {}", type);
        return temperatureDao.getLastEntityForGivenType(type.getType());
    }
}
