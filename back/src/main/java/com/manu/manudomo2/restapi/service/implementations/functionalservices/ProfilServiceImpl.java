package com.manu.manudomo2.restapi.service.implementations.functionalservices;

import com.manu.manudomo2.restapi.data.dao.interfaces.ComChauffDao;
import com.manu.manudomo2.restapi.data.dao.interfaces.ModeChauffDao;
import com.manu.manudomo2.restapi.data.dao.interfaces.TempChauffDao;
import com.manu.manudomo2.restapi.data.entities.ComChauff;
import com.manu.manudomo2.restapi.data.entities.ModeChauff;
import com.manu.manudomo2.restapi.data.entities.TempChauff;
import com.manu.manudomo2.restapi.service.interfaces.ProfilService;
import com.manu.manudomo2.restapi.service.viewmodels.ProfilVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProfilServiceImpl implements ProfilService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilServiceImpl.class);
    @Autowired
    private ComChauffDao comChauffDao;
    @Autowired
    private ModeChauffDao modeChauffDao;
    @Autowired
    private TempChauffDao tempChauffDao;

    @Override
    @Transactional(readOnly = false)
    public ProfilVm updateProfil(ProfilVm profilVm) {

        ModeChauff modeChauff = new ModeChauff();
        modeChauff.setHourMode(profilVm.getModeChauff());
        modeChauff.setDate(new Date());
        modeChauffDao.save(modeChauff);
        ComChauff comChauff = new ComChauff();
        comChauff.setOnoff(profilVm.getComChauff());
        comChauff.setDate(new Date());
        comChauffDao.save(comChauff);
        TempChauff globalTemp = tempChauffDao.getGlobalTemp();
        globalTemp.setTemp(profilVm.getGlobalTemperature());
        tempChauffDao.save(globalTemp);

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        if (profilVm.updateTempProfile()) {
            for (Integer startHour = profilVm.getStartHour(); startHour < profilVm.getEndHour(); startHour++) {
                try {
                    Date startDate = sdf.parse(startHour.toString());
                    TempChauff currentTemp = tempChauffDao.getGlobalTempForStartHour(startDate);
                    currentTemp.setTemp(profilVm.getProfilTemp());
                    tempChauffDao.save(currentTemp);
                } catch (ParseException e) {
                    LOGGER.error("ParseException: {}", startHour, e);
                    break;
                }
            }
        }
        return this.getProfil();
    }

    private Map<Integer, Integer> getCompleteTempProfile() {
        Map<Integer, Integer> result = new HashMap<>();
        List<TempChauff> tempChauffList = tempChauffDao.getCompleteProfile();
        for (TempChauff tempChauff : tempChauffList) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(tempChauff.getStartHour());
            result.put(calendar.get(Calendar.HOUR_OF_DAY), tempChauff.getTemp());
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public ProfilVm getProfil() {
        ComChauff comChauff = comChauffDao.getLastEntityForGivenType(null);
        ModeChauff modeChauff = modeChauffDao.getLastEntityForGivenType(null);
        TempChauff tempChauff = tempChauffDao.getGlobalTemp();
        ProfilVm result = new ProfilVm();
        result.setComChauff(comChauff.getOnoff());
        result.setModeChauff(modeChauff.getHourMode());
        result.setGlobalTemperature(tempChauff.getTemp());
        result.setHourTempMap(this.getCompleteTempProfile());
        return result;
    }
}
