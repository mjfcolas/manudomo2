package com.manu.manudomo2.restapi.service.implementations.entityservices;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.config.AppConfig;
import com.manu.manudomo2.restapi.data.dao.interfaces.EdfIndexDao;
import com.manu.manudomo2.restapi.data.entities.EdfIndex;
import com.manu.manudomo2.restapi.service.interfaces.EdfIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EdfIndexServiceImpl implements EdfIndexService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EdfIndexServiceImpl.class);
    @Autowired
    private EdfIndexDao edfIndexDao;

    @Override
    @Transactional(readOnly = true)
    public Double getPriceBetweenDates(Date fromDate, Date endDate, EdfPrice price) {
        EdfIndex startIndex = edfIndexDao.getFirstEdfIndexAfterDate(fromDate, price);
        EdfIndex endIndex = edfIndexDao.getLastEdfIndexBeforeDate(endDate, price);
        String keyPrice = EdfPrice.HC.equals(price) ? "manudomo2.edf.price.hc" : "manudomo2.edf.price.hp";
        Double priceValue = Double.parseDouble(AppConfig.prop().getProperty(keyPrice));

        return (endIndex.getValue() - startIndex.getValue()) * 0.001 * priceValue;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EdfIndex> getEdfIndexBetweenDates(Date fromDate, Date toDate, EdfPrice type) {
        LOGGER.debug("IN - EdfIndexServiceImpl.getEdfIndexDates -fromDate: {} - toDate {} - type {}", fromDate, toDate, type);
        return edfIndexDao.getEdfIndexBetweenDatesForGivenType(fromDate, toDate, type.getType());
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getEnergyForPeriod(DateInterval dates, EdfPrice priceType){
        LOGGER.debug("IN - EdfIndexServiceImpl.getPowerForPeriod -fromDate: {} - toDate {} - type {}", dates.getFromDate(), dates.getToDate(), priceType);
        EdfIndex startValue = edfIndexDao.getFirstEdfIndexAfterDate(dates.getFromDate(), priceType);
        EdfIndex endValue = edfIndexDao.getLastEdfIndexBeforeDate(dates.getToDate(), priceType);
        return endValue.getValue() - startValue.getValue();
    }
}
