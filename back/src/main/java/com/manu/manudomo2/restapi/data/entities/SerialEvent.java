package com.manu.manudomo2.restapi.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "error_seq")
@Table(name = "serial_event")
public class SerialEvent extends DateEntity {
    @Column(name = "error_type")
    private String errorType;
    private boolean success;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(final String errorType) {
        this.errorType = errorType;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

}
