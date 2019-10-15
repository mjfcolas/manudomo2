package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.entities.Intensity;

import java.util.List;

public interface IntensityService {
    List<Intensity> getIntensityBetweenDates(DateInterval dates);

}
