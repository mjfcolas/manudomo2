package com.manu.manudomo2.restapi.web.controller;

import com.manu.manudomo2.restapi.config.AppConfig;
import com.manu.manudomo2.restapi.service.interfaces.GeneralInfosService;
import com.manu.manudomo2.restapi.service.viewmodels.GeneralInfosVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class GeneralInfosController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralInfosController.class);

    @Autowired
    GeneralInfosService generalInfosService;

    @GetMapping("private/generalInfos")
    public GeneralInfosVm generalInfos(String startTime, String endTime) {
        LOGGER.debug("IN - GeneralInfosVm.generalInfos - startTime {} - endTime {}", startTime, endTime);

        SimpleDateFormat formatter = new SimpleDateFormat(AppConfig.prop().getProperty("manudomo2.dateformat"));
        Date fromTimeDate = null;
        Date endTimeDate = null;

        if (startTime != null) {
            try {
                fromTimeDate = formatter.parse(startTime);
            } catch (ParseException e) {
                fromTimeDate = null;
            }
        }

        if (endTime != null) {
            try {
                endTimeDate = formatter.parse(endTime);
            } catch (ParseException e) {
                endTimeDate = null;
            }
        }

        return generalInfosService.getGeneralInfos(fromTimeDate, endTimeDate);
    }
}
