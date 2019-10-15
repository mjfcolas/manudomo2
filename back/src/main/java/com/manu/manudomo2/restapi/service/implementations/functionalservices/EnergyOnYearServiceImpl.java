package com.manu.manudomo2.restapi.service.implementations.functionalservices;

import com.manu.manudomo2.restapi.common.enums.EdfPrice;
import com.manu.manudomo2.restapi.common.enums.TimeScale;
import com.manu.manudomo2.restapi.common.utils.DateInterval;
import com.manu.manudomo2.restapi.data.dao.interfaces.EdfIndexDao;
import com.manu.manudomo2.restapi.service.interfaces.EdfIndexService;
import com.manu.manudomo2.restapi.service.interfaces.EnergyOnYearService;
import com.manu.manudomo2.restapi.service.viewmodels.EnergyOnYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EnergyOnYearServiceImpl implements EnergyOnYearService {

    @Autowired
    EdfIndexService edfIndexService;
    @Autowired
    EdfIndexDao edfIndexDao;

    @Override
    @Transactional(readOnly = true)
    public List<EnergyOnYear> getEnergyOnYears(TimeScale timeScale) {

        Date firstDate = edfIndexDao.getFirstIndex(EdfPrice.HP).getDate();
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(firstDate);

        Date endDate = edfIndexDao.getLastIndex(EdfPrice.HP).getDate();
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        int startYear = firstCalendar.get(Calendar.YEAR);
        int endYear = endCalendar.get(Calendar.YEAR);
        int startMonth = firstCalendar.get(Calendar.MONTH);
        int endMonth = endCalendar.get(Calendar.MONTH);
        if (timeScale == TimeScale.MONTH) {
            startMonth = startMonth + 1;
        }
        firstCalendar = Calendar.getInstance();
        firstCalendar.set(startYear, startMonth, 1, 0, 0, 0);
        endCalendar = Calendar.getInstance();
        endCalendar.set(endYear, endMonth, 1, 0, 0, 0);

        Calendar currentStartCalendar = (Calendar) firstCalendar.clone();
        Calendar currentEndCalendar = (Calendar) firstCalendar.clone();
        currentEndCalendar.add(Calendar.MONTH, 1);

        List<EnergyOnYear> result = new ArrayList<>();
        int currentYear = 0;
        EnergyOnYear currentElement = null;
        while (currentEndCalendar.compareTo(endCalendar) <= 0) {
            if (currentYear == 0 || currentYear != currentStartCalendar.get(Calendar.YEAR)) {
                currentYear = currentStartCalendar.get(Calendar.YEAR);
                currentElement = new EnergyOnYear();
                currentElement.setTimeScale(timeScale);
                currentElement.setYear(currentYear);
                result.add(currentElement);
            }
            DateInterval currentDateInterval = new DateInterval(currentStartCalendar.getTime(), currentEndCalendar.getTime());

            //Avoid negative value due to an index reinitialisation
            Integer energyOnPeriodHp = Math.max(0, edfIndexService.getEnergyForPeriod(currentDateInterval, EdfPrice.HP));
            Integer energyOnPeriodHc = Math.max(0, edfIndexService.getEnergyForPeriod(currentDateInterval, EdfPrice.HC));
            currentElement.getValues().put(currentStartCalendar.get(Calendar.MONTH), energyOnPeriodHp + energyOnPeriodHc);

            currentStartCalendar.add(Calendar.MONTH, 1);
            currentEndCalendar.add(Calendar.MONTH, 1);
        }

        return result;
    }
}
