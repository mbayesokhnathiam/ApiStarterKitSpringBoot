package sn.gainde.api.service;

import org.springframework.data.domain.Page;
import sn.gainde.api.model.Utilisateur;
import sn.gainde.api.web.dto.model.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur saveUser(Utilisateur utilisateur);
    Utilisateur editUser(long id, UtilisateurDto userDto);
    Page<Utilisateur> getListUtilisateurs(int page, int size);
    Utilisateur getUserById(Long id);
}
