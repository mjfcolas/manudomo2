package com.manu.manudomo2.restapi.common.enums;

public enum EdfPrice {
    HC(1),
    HP(2);

    private int type;
    EdfPrice(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }
}
