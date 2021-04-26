package com.azertysolutions.api.repository;

import com.azertysolutions.api.model.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MTHIAM 
 */

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findAll(Pageable pageable);
}
