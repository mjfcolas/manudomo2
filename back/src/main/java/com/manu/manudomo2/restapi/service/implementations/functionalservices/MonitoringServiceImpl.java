package com.manu.manudomo2.restapi.service.implementations.functionalservices;

import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.entities.SerialEvent;
import com.manu.manudomo2.restapi.service.interfaces.MonitoringService;
import com.manu.manudomo2.restapi.service.interfaces.SerialEventService;
import com.manu.manudomo2.restapi.service.viewmodels.MonitoringVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringServiceImpl implements MonitoringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitoringServiceImpl.class);

    @Autowired
    SerialEventService serialEventService;

    @Override
    public MonitoringVm getMonitoringVm(DateInterval dateInterval) {
        LOGGER.debug("IN - MonitoringServiceImpl.getMonitoringVm -fromDate: {} - toDate {}", dateInterval.getFromDate(), dateInterval.getToDate());
        List<SerialEvent> rawResult = serialEventService.getSerialEventBetweenDates(dateInterval.getFromDate(), dateInterval.getToDate());
        return new MonitoringVm(rawResult);
    }
}
