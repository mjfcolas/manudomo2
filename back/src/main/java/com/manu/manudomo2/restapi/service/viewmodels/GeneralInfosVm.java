package com.manu.manudomo2.restapi.service.viewmodels;

public class GeneralInfosVm {

    private double livingRoomTemp;
    private double roomTemp;
    private double hygro;
    private double normPressure;
    private double hpPrice;
    private double hcPrice;

    public double getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(final double roomTemp) {
        this.roomTemp = roomTemp;
    }

    public double getNormPressure() {
        return normPressure;
    }

    public void setNormPressure(final double normPressure) {
        this.normPressure = normPressure;
    }

    public double getHpPrice() {
        return hpPrice;
    }

    public void setHpPrice(final double hpPrice) {
        this.hpPrice = hpPrice;
    }

    public double getHygro() {
        return hygro;
    }

    public void setHygro(final double hygro) {
        this.hygro = hygro;
    }

    public double getLivingRoomTemp() {
        return livingRoomTemp;
    }

    public void setLivingRoomTemp(final double livingRoomTemp) {
        this.livingRoomTemp = livingRoomTemp;
    }

    public double getHcPrice() {
        return hcPrice;
    }

    public void setHcPrice(final double hcPrice) {
        this.hcPrice = hcPrice;
    }
}
