package com.manu.manudomo2.restapi.web.controller;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.common.enums.TimeScale;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.service.interfaces.DatasetService;
import com.manu.manudomo2.restapi.service.interfaces.EnergyOnYearService;
import com.manu.manudomo2.restapi.service.viewmodels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataSetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSetController.class);

    @Autowired
    DatasetService datasetService;
    @Autowired
    EnergyOnYearService energyOnYearService;

    @GetMapping("private/temperature/livingroomList")
    public List<TemperatureVm> livingRoomTemperatureList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.livingRoomTemperatureList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getTemperatureList(new DateInterval(startTime, endTime), TemperatureType.SALON);
    }

    @GetMapping("private/temperature/roomList")
    public List<TemperatureVm> roomTemperatureList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.roomTemperatureList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getTemperatureList(new DateInterval(startTime, endTime), TemperatureType.CHAMBRE);
    }

    @GetMapping("private/pressure/list")
    public List<PressureVm> livingRoomPressureList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.livingRoomPressureList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getPressureList(new DateInterval(startTime, endTime));
    }

    @GetMapping("private/hygro/list")
    public List<HygroVm> hygroList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.hygroList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getHygroList(new DateInterval(startTime, endTime));
    }

    @GetMapping("private/edf/hcList")
    public List<EdfIndexVm> edfHcList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.edfHcList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getEdfIndexList(new DateInterval(startTime, endTime), EdfPrice.HC);
    }

    @GetMapping("private/edf/hpList")
    public List<EdfIndexVm> edfHpList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.edfHpList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getEdfIndexList(new DateInterval(startTime, endTime), EdfPrice.HP);
    }

    @GetMapping("private/edf/intensityList")
    public List<IntensityVm> edfIntensityList(String startTime, String endTime) {
        LOGGER.debug("IN - DataSetController.edfHpList - startTime {} - endTime {}", startTime, endTime);

        return datasetService.getDecimatedIntensityBetweenDates(new DateInterval(startTime, endTime));
    }

    @GetMapping("private/edf/energyonyears")
    public List<EnergyOnYear> getEnergyOnYears() {
        LOGGER.debug("IN - DataSetController.getEnergyOnYears");

        return energyOnYearService.getEnergyOnYears(TimeScale.MONTH);
    }
}
