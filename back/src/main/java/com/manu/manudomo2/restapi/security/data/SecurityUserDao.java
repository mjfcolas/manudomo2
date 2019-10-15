package com.manu.manudomo2.restapi.security.data;

import com.manu.manudomo2.restapi.security.model.SecurityUser;

public interface SecurityUserDao<T extends SecurityUser> {
    T findByUsername(String username);

    void save(T securityUser);
}
