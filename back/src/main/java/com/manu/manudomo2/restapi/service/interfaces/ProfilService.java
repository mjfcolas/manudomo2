package com.manu.manudomo2.restapi.service.interfaces;

import com.manu.manudomo2.restapi.service.viewmodels.ProfilVm;

public interface ProfilService {
    ProfilVm updateProfil(ProfilVm profilVm);

    ProfilVm getProfil();
}
