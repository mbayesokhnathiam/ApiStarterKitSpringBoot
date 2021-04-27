package sn.gainde.sut.portail.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

/**
 * @author MTHIAM
 */

@Data
@Entity
@Table(name = "td_utilisateur")
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 8027589498244487525L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="utiId")
    private Long id;
	@Column(name="uti_prenom")
    private String prenom;
	@Column(name="uti_nom")
    private String nom;
	@Column(name="uti_telephone")
    private String telephone;
    @Column(name="uti_email", unique = true)
    private String email;
	@Column(name="uti_password")
    private String password;
	@Column(name="uti_statut")
    private boolean statut=true;
    @ManyToOne
    @JoinColumn(name="uti_pro_id")
    private Profil profil;

}
