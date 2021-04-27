package sn.gainde.sut.portail.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.gainde.sut.portail.entities.Utilisateur;
import sn.gainde.sut.portail.repositories.UserRepository;
import sn.gainde.sut.portail.services.UtilisateurService;
import sn.gainde.sut.portail.web.dto.model.UtilisateurDto;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
        try {
            return  userRepository.save(utilisateur);

        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Utilisateur editUser(Integer id, UtilisateurDto userDto) {
        Utilisateur currentUser = userRepository.findById(id).orElse(null);
        currentUser.setEmail(userDto.getEmail());
        currentUser.setNom(userDto.getNom());
        currentUser.setPrenom(userDto.getPrenom());
        currentUser.setTelephone(userDto.getTelephone());

        Utilisateur userUpdated = userRepository.save(currentUser);

        return userUpdated;
    }

    @Override
    public Page<Utilisateur> getListUtilisateurs(int page, int size) {

        Pageable requestedPage = PageRequest.of(page, size);

        return userRepository.findAll(requestedPage);
    }

    @Override
    public Utilisateur getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}