package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.enums.TimeScale;
import com.manu.manudomo2.restapi.service.viewmodels.EnergyOnYear;

import java.util.List;

public interface EnergyOnYearService {

    List<EnergyOnYear> getEnergyOnYears(TimeScale timeScale);
}
