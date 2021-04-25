package com.azertysolutions.api.model;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
/**
 * 
 * @author MTHIAM
 *
 */
@Data
@Entity
@Table(name = "tp_menu_item")
public class Menu implements Serializable {
	private static final long serialVersionUID = 410357248812085729L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private String icon;
    private String route;
    private long parent_id;
    private long priorite;
    private Long profil;

}

