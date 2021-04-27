package sn.gainde.sut.portail.entities;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
/**
 * 
 * @author MTHIAM
 *
 */
@Data
@Entity
@Table(name = "TP_Menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1071795283000704295L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Men_Id")
    private Long id;

	@Column(name = "Men_Libelle")
    private String libelle;

    @Size(max = 5)
    @Column(name = "Men_Code")
    private String code;

    @Column(name = "Men_Icon")
    private String icon;

    @Column(name = "Men_Route")
    private String route;

    @Column(name = "Men_ParentId")
    private long parent_id;

    @Column(name = "Men_Priorite")
    private long priorite;

    @Column(name = "Men_Pro_Id")
    private Integer profil;

}

