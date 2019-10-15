package com.manu.manudomo2.restapi.service.viewmodels;

import com.manu.manudomo2.restapi.data.entities.SerialEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MonitoringVm {

    private final List<SerialEvent> serialEventList = new ArrayList<>();
    private final List<DateValuePoint> qtErrorPointsAdded;
    private final List<DateValuePoint> nErrorPointsAdded;
    private final List<DateValuePoint> dErrorPointsAdded;
    private final List<DateValuePoint> cErrorPointsAdded;
    private final List<DateValuePoint> qtSuccessPointsAdded;
    private final List<DateValuePoint> nSuccessPointsAdded;
    private final List<DateValuePoint> dSuccessPointsAdded;
    private final List<DateValuePoint> cSuccessPointsAdded;
    private final Integer qtErrorNumber;
    private final Integer nErrorNumber;
    private final Integer cErrorNumber;
    private final Integer dErrorNumber;
    private final Integer qtSuccessNumber;
    private final Integer nSuccessNumber;
    private final Integer cSuccessNumber;
    private final Integer dSuccessNumber;

    public MonitoringVm(List<SerialEvent> serialEvents) {
        this.serialEventList.addAll(serialEvents);
        this.qtErrorPointsAdded = this.getGivenPointsAdded("QT", true);
        this.nErrorPointsAdded = this.getGivenPointsAdded("N", true);
        this.dErrorPointsAdded = this.getGivenPointsAdded("D", true);
        this.cErrorPointsAdded = this.getGivenPointsAdded("C", true);
        this.qtSuccessPointsAdded = this.getGivenPointsAdded("QT", false);
        this.nSuccessPointsAdded = this.getGivenPointsAdded("N", false);
        this.dSuccessPointsAdded = this.getGivenPointsAdded("D", false);
        this.cSuccessPointsAdded = this.getGivenPointsAdded("C", false);

        this.qtErrorNumber = qtErrorPointsAdded.size();
        this.nErrorNumber = nErrorPointsAdded.size();
        this.cErrorNumber = cErrorPointsAdded.size();
        this.dErrorNumber = dErrorPointsAdded.size();
        this.qtSuccessNumber = qtSuccessPointsAdded.size();
        this.nSuccessNumber = nSuccessPointsAdded.size();
        this.cSuccessNumber = cSuccessPointsAdded.size();
        this.dSuccessNumber = dSuccessPointsAdded.size();
    }

    public List<DateValuePoint> getQtErrorPointsAdded() {
        return qtErrorPointsAdded;
    }

    public List<DateValuePoint> getNErrorPointsAdded() {
        return nErrorPointsAdded;
    }

    public List<DateValuePoint> getDErrorPointsAdded() {
        return dErrorPointsAdded;
    }

    public List<DateValuePoint> getCErrorPointsAdded() {
        return cErrorPointsAdded;
    }

    public Integer getQtErrorNumber() {
        return qtErrorNumber;
    }

    public Integer getnErrorNumber() {
        return nErrorNumber;
    }

    public Integer getcErrorNumber() {
        return cErrorNumber;
    }

    public Integer getdErrorNumber() {
        return dErrorNumber;
    }

    public Integer getQtSuccessNumber() {
        return qtSuccessNumber;
    }

    public Integer getnSuccessNumber() {
        return nSuccessNumber;
    }

    public Integer getcSuccessNumber() {
        return cSuccessNumber;
    }

    public Integer getdSuccessNumber() {
        return dSuccessNumber;
    }

    private List<DateValuePoint> getGivenPointsAdded(String errorType, boolean isError) {
        List<DateValuePoint> result = new ArrayList<>();
        List<SerialEvent> xSerialEvents = serialEventList.stream().filter(x -> x.isSuccess() == !isError && errorType.equals(x.getErrorType())).collect(Collectors.toList());
        Integer counter = 1;
        for (int i = xSerialEvents.size() - 1; i >= 0; i--) {
            String value = counter.toString();
            result.add(new DateValuePoint(xSerialEvents.get(i).getDate(), value));
            counter++;
        }
        return result;
    }
}
