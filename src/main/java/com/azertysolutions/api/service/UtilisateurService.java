package com.azertysolutions.api.service;

import com.azertysolutions.api.model.Utilisateur;
import com.azertysolutions.api.web.dto.model.UtilisateurDto;
import org.springframework.data.domain.Page;

public interface UtilisateurService {

    Utilisateur saveUser(Utilisateur utilisateur);
    Utilisateur editUser(long id, UtilisateurDto userDto);
    Page<Utilisateur> getListUtilisateurs(int page, int size);
    Utilisateur getUserById(Long id);
}
