package com.manu.manudomo2.restapi.common.enums;

public enum TemperatureType {
    SALON(1),
    CHAMBRE(2);

    private int type;
    TemperatureType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }
}
