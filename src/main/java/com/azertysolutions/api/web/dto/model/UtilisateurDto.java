package com.azertysolutions.api.web.dto.model;

import lombok.Data;

@Data
public class UtilisateurDto {
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
    private String password;
    private Long profil_id;
}
