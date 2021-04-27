package sn.gainde.sut.portail.services;

import org.springframework.data.domain.Page;
import sn.gainde.sut.portail.entities.Utilisateur;
import sn.gainde.sut.portail.web.dto.model.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur saveUser(Utilisateur utilisateur);
    Utilisateur editUser(Integer id, UtilisateurDto userDto);
    Page<Utilisateur> getListUtilisateurs(int page, int size);
    Utilisateur getUserById(Integer id);
}
