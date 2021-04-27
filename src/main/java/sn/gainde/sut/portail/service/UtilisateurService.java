package sn.gainde.sut.portail.service;

import org.springframework.data.domain.Page;
import sn.gainde.sut.portail.model.Utilisateur;
import sn.gainde.sut.portail.web.dto.model.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur saveUser(Utilisateur utilisateur);
    Utilisateur editUser(long id, UtilisateurDto userDto);
    Page<Utilisateur> getListUtilisateurs(int page, int size);
    Utilisateur getUserById(Long id);
}
