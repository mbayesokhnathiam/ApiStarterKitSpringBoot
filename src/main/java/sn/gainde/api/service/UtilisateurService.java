package sn.gainde.api.service;

import org.springframework.data.domain.Page;
import sn.gainde.api.model.Utilisateur;
import sn.gainde.api.web.dto.model.UtilisateurDto;

public interface UtilisateurService {

    boolean saveUser(Utilisateur utilisateur);
    boolean editUser(long id, UtilisateurDto userDto);
    Page<Utilisateur> getListUtilisateurs(int page, int size);
}
