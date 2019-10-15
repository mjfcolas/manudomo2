package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ValuableEntity<T extends Number> extends DateEntity {

    protected T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
