package sn.gainde.api.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.gainde.api.model.Utilisateur;
import sn.gainde.api.repository.UserRepository;
import sn.gainde.api.service.UtilisateurService;
import sn.gainde.api.web.dto.model.UtilisateurDto;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean saveUser(Utilisateur utilisateur) {
        try {
            userRepository.save(utilisateur);
            return  true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean editUser(long id, UtilisateurDto userDto) {
        return false;
    }

    @Override
    public Page<Utilisateur> getListUtilisateurs(int page, int size) {

        Pageable requestedPage = PageRequest.of(page, size);

        return userRepository.findAll(requestedPage);
    }
}
