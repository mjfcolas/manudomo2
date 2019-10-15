package com.manu.manudomo2.restapi.security.model;

import javax.persistence.*;


public interface SecurityUser {
    int getId();
    void setId(int id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);

}

