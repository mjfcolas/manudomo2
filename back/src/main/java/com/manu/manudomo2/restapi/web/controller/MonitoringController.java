package com.manu.manudomo2.restapi.web.controller;

import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.service.interfaces.MonitoringService;
import com.manu.manudomo2.restapi.service.viewmodels.MonitoringVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitoringController.class);

    @Autowired
    private MonitoringService monitoringService;

    @GetMapping("private/monitoring/get")
    public MonitoringVm getMonitoring(String startTime, String endTime) {
        LOGGER.debug("IN - MonitoringController.getMonitoring");
        return monitoringService.getMonitoringVm(new DateInterval(startTime, endTime));
    }
}