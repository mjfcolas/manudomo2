package com.manu.manudomo2.restapi.config;

public class SecurityConfigWrapper {

    private Class securityUserClass;

    public SecurityConfigWrapper(Class securityUserClass) {
        this.securityUserClass = securityUserClass;
    }

    public Class getSecurityUserClass() {
        return securityUserClass;
    }

}
