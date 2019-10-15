package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.service.viewmodels.GeneralInfosVm;

import java.util.Date;

public interface GeneralInfosService {
    GeneralInfosVm getGeneralInfos(Date fromTime, Date endTime);
}
