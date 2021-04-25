package com.azertysolutions.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author MTHIAM
 */
@Entity
@Data
@Table(name = "TP_Profil")
public class Profil implements Serializable {

	private static final long serialVersionUID = 2587148813322819863L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code; 
    private String domaine;
    @OneToMany(mappedBy = "profil")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;


}

