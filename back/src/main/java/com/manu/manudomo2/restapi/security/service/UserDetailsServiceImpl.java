package com.manu.manudomo2.restapi.security.service;

import com.manu.manudomo2.restapi.security.data.SecurityUserDao;
import com.manu.manudomo2.restapi.security.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, SecurityUserService {

    @Autowired
    private SecurityUserDao securityUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        SecurityUser user = securityUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SecurityUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.securityUserDao.save(user);
    }
}
