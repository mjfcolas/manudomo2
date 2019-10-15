package com.manu.manudomo2.restapi.web.controller;

import com.manu.manudomo2.restapi.service.interfaces.ProfilService;
import com.manu.manudomo2.restapi.service.viewmodels.ProfilVm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilController.class);

    @Autowired
    private ProfilService profilService;

    @PostMapping("private/profil/save")
    public ProfilVm saveProfil(@RequestBody ProfilVm profilVm) {
        LOGGER.debug("IN - ProfilController.saveProfil");
        return profilService.updateProfil(profilVm);
    }

    @GetMapping("private/profil/get")
    public ProfilVm getProfil() {
        LOGGER.debug("IN - ProfilController.getProfil");
        return profilService.getProfil();
    }
}