package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.common.enums.TimeScale;

import java.util.HashMap;
import java.util.Map;

public class EnergyOnYear {
    private TimeScale timeScale = null;
    private int year = 0;
    private Map<Integer, Integer> values = new HashMap<>();

    public TimeScale getTimeScale() {
        return timeScale;
    }

    public void setTimeScale(final TimeScale timeScale) {
        this.timeScale = timeScale;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public Map<Integer, Integer> getValues() {
        return values;
    }

    public void setValues(final Map<Integer, Integer> values) {
        this.values = values;
    }
}
