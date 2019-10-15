package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.dao.interfaces.IntensityDao;
import com.manu.manudomo2.restapi.data.entities.Intensity;
import com.manu.manudomo2.restapi.service.interfaces.IntensityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IntensityServiceImpl implements IntensityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntensityServiceImpl.class);

    @Autowired
    protected IntensityDao intensityDao;

    @Transactional(readOnly = true)
    public List<Intensity> getIntensityBetweenDates(DateInterval dates) {
        LOGGER.debug("IN - IntensityServiceImpl.getIntensityBetweenDates - fromDate: {} - toDate {}", dates.getFromDate(), dates.getToDate());
        return intensityDao.getEntityBetweenDates(dates.getFromDate(), dates.getToDate());
    }
}
