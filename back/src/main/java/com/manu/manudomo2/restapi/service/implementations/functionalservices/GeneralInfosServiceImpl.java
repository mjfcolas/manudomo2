package com.manu.manudomo2.restapi.service.implementations.functionalservices;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.data.dao.interfaces.HygroDao;
import com.manu.manudomo2.restapi.data.dao.interfaces.PressureDao;
import com.manu.manudomo2.restapi.service.interfaces.*;
import com.manu.manudomo2.restapi.service.viewmodels.GeneralInfosVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class GeneralInfosServiceImpl implements GeneralInfosService {

    @Autowired
    TemperatureService temperatureService;
    @Autowired
    PressureDao pressureDao;
    @Autowired
    EdfIndexService edfIndexService;
    @Autowired
    HygroDao hygroDao;

    @Override
    @Transactional(readOnly = true)
    public GeneralInfosVm getGeneralInfos(Date fromTime, Date endTime) {
        GeneralInfosVm result = new GeneralInfosVm();
        result.setLivingRoomTemp(temperatureService.getLastTemperature(TemperatureType.SALON).getValue());
        result.setRoomTemp(temperatureService.getLastTemperature(TemperatureType.CHAMBRE).getValue());
        result.setNormPressure(pressureDao.getLastEntityForGivenType(null).getValueRel());
        result.setHcPrice(edfIndexService.getPriceBetweenDates(fromTime, endTime, EdfPrice.HC));
        result.setHpPrice(edfIndexService.getPriceBetweenDates(fromTime, endTime, EdfPrice.HP));
        result.setHygro(hygroDao.getLastEntityForGivenType(null).getValue());
        return result;
    }
}
