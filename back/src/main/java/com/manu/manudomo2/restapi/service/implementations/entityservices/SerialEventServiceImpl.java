package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.data.dao.interfaces.SerialEventDao;
import com.manu.manudomo2.restapi.data.entities.SerialEvent;
import com.manu.manudomo2.restapi.service.interfaces.SerialEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SerialEventServiceImpl implements SerialEventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerialEventServiceImpl.class);
    @Autowired
    private SerialEventDao serialEventDao;

    @Override
    @Transactional(readOnly = true)
    public List<SerialEvent> getSerialEventBetweenDates(Date fromDate, Date toDate) {
        LOGGER.debug("IN - SerialEventServiceImpl.getSerialEventBetweenDates -fromDate: {} - toDate {}", fromDate, toDate);
        return serialEventDao.getEntityBetweenDates(fromDate, toDate);
    }
}
