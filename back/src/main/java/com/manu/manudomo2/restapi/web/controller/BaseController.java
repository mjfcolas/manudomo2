package com.manu.manudomo2.restapi.web.controller;

import com.manu.manudomo2.restapi.data.entities.User;
import com.manu.manudomo2.restapi.security.service.SecurityUserService;
import com.manu.manudomo2.restapi.service.viewmodels.UserVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private SecurityUserService securityUserService;

    @PostMapping("private/sign-up")
    public void signUp(@RequestBody UserVm securityUser) {
        securityUserService.save(new User(securityUser.getUsername(), securityUser.getPassword()));
    }
}
