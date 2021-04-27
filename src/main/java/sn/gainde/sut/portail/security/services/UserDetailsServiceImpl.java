package sn.gainde.sut.portail.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.gainde.sut.portail.entities.Utilisateur;
import sn.gainde.sut.portail.repositories.UserRepository;

/*
Il est simple à mettre en œuvre UserDetailsService et facile pour nous de
récupérer les informations d' authentication à l' aide d' une stratégie de
persistance:
- UserDetailsServiceImpl met en œuvre UserDetailsService et remplace la
loadUserByUsername() méthode.
loadUserByUsername recherche un enregistrement dans les tables de la base de
données des utilisateurs pour créer un UserDetails objet pour
l' authentication.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Utilisateur introuvable avec -> nom d'utilisateur ou e-mail: " + username));

        return UserPrinciple.build(utilisateur);
    }
}