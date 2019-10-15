package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.service.viewmodels.MonitoringVm;

public interface MonitoringService {
    MonitoringVm getMonitoringVm(DateInterval dateInterval);

}
