package com.manu.manudomo2.restapi.service.implementations.functionalservices;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.entities.*;
import com.manu.manudomo2.restapi.service.interfaces.*;
import com.manu.manudomo2.restapi.service.utils.ValuableCollectionUtils;
import com.manu.manudomo2.restapi.service.viewmodels.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataSetServiceImpl implements DatasetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSetServiceImpl.class);

    @Autowired
    TemperatureService temperatureService;
    @Autowired
    EdfIndexService edfIndexService;
    @Autowired
    IntensityService intensityService;
    @Autowired
    PressureService pressureService;
    @Autowired
    HygroService hygroService;

    @Override
    public List<TemperatureVm> getTemperatureList(DateInterval dateInterval, TemperatureType type) {
        List<Temperature> rawResult = temperatureService.getTemperatureBetweenDates(dateInterval.getFromDate(), dateInterval.getToDate(), type);
        new ValuableCollectionUtils<Temperature>().decimateList(rawResult, 0.1);
        return rawResult.stream().map(TemperatureVm::new).collect(Collectors.toList());
    }

    @Override
    public List<PressureVm> getPressureList(DateInterval dateInterval) {
        List<Pressure> rawResult = pressureService.getPressureBetweenDates(dateInterval.getFromDate(), dateInterval.getToDate());
        return rawResult.stream().map(PressureVm::new).collect(Collectors.toList());
    }

    @Override
    public List<HygroVm> getHygroList(DateInterval dateInterval) {
        List<Hygro> rawResult = hygroService.getHygroBetweenDates(dateInterval.getFromDate(), dateInterval.getToDate());
        new ValuableCollectionUtils<Hygro>().decimateList(rawResult, 0.1);
        return rawResult.stream().map(HygroVm::new).collect(Collectors.toList());
    }

    @Override
    public List<EdfIndexVm> getEdfIndexList(DateInterval dateInterval, EdfPrice type) {
        List<EdfIndex> rawResult = edfIndexService.getEdfIndexBetweenDates(dateInterval.getFromDate(), dateInterval.getToDate(), type);
        ValuableCollectionUtils valuableCollectionUtils = new ValuableCollectionUtils<Temperature>();
        valuableCollectionUtils.moduloReduction(rawResult, 100);
        valuableCollectionUtils.decimateList(rawResult, 100);
        return rawResult.stream().map(EdfIndexVm::new).collect(Collectors.toList());
    }

    @Override
    public List<IntensityVm> getDecimatedIntensityBetweenDates(DateInterval dateInterval) {
        LOGGER.debug("IN - DataSetServiceImpl.getDecimatedIntensityBetweenDates - fromDate: {} - toDate {}", dateInterval.getFromDate(), dateInterval.getToDate());
        List<Intensity> rawResult = intensityService.getIntensityBetweenDates(dateInterval);

        new ValuableCollectionUtils<Intensity>().decimateList(rawResult, 0);
        return rawResult.stream().map(IntensityVm::new).collect(Collectors.toList());
    }
}
