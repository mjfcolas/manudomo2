package com.manu.manudomo2.restapi.service.viewmodels;

import java.util.HashMap;
import java.util.Map;

public class ProfilVm {

    private Boolean comChauff;
    private Boolean modeChauff;
    private Integer globalTemperature;
    private Integer startHour;
    private Integer endHour;
    private Integer profilTemp;
    private Map<Integer, Integer> hourTempMap = new HashMap<>();

    public Boolean getComChauff() {
        return comChauff;
    }

    public void setComChauff(final Boolean comChauff) {
        this.comChauff = comChauff;
    }

    public Boolean getModeChauff() {
        return modeChauff;
    }

    public void setModeChauff(final Boolean modeChauff) {
        this.modeChauff = modeChauff;
    }

    public Integer getGlobalTemperature() {
        return globalTemperature;
    }

    public void setGlobalTemperature(final Integer globalTemperature) {
        this.globalTemperature = globalTemperature;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(final Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(final Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getProfilTemp() {
        return profilTemp;
    }

    public void setProfilTemp(final Integer profilTemp) {
        this.profilTemp = profilTemp;
    }

    public Map<Integer, Integer> getHourTempMap() {
        return hourTempMap;
    }

    public void setHourTempMap(final Map<Integer, Integer> hourTempMap) {
        this.hourTempMap = hourTempMap;
    }

    public boolean updateTempProfile(){
        return startHour != null && endHour != null && profilTemp != null;
    }
}
