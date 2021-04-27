package sn.gainde.sut.portail.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.gainde.sut.portail.model.Utilisateur;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findAll(Pageable pageable);
    public Utilisateur findUtilisateurByEmailAndPassword(String login, String password);
    Optional<Utilisateur> findUtilisateurByEmail(String userName);
}
