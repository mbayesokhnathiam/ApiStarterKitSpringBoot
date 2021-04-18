package sn.gainde.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.gainde.api.model.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findAll(Pageable pageable);
}
