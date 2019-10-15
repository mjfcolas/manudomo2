package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.enums.TemperatureType;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.service.viewmodels.*;

import java.util.List;

public interface DatasetService {
    List<TemperatureVm> getTemperatureList(DateInterval dateInterval, TemperatureType type);

    List<EdfIndexVm> getEdfIndexList(DateInterval dateInterval, EdfPrice type);

    List<IntensityVm> getDecimatedIntensityBetweenDates(DateInterval dateInterval);

    List<PressureVm> getPressureList(DateInterval dateInterval);

    List<HygroVm> getHygroList(DateInterval dateInterval);
}
