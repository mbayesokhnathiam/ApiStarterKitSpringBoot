package sn.gainde.sut.portail.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

/**
 * @author MTHIAM
 */

@Data
@Table(name = "TD_Utilisateur")
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable{
    private static final long serialVersionUID = -128668550641325448L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Uti_Id")
    private Integer id;

    @Size(max = 100)
    @Column(name = "Uti_Email", unique = true)
    private String email;

    @Size(max = 50)
    @Column(name = "Uti_Telephone")
    private String telephone;

    @CreationTimestamp
    @Column(name = "Uti_DateCreation")
    private Date dateCreation;

    @Size(max = 100)
    @Column(name = "Uti_Login", unique = true)
    private String login;

    @Column(name = "Uti_Password")
    private String password;

    @Size(max = 50)
    @Column(name = "Uti_Nom")
    private String nom;

    @Size(max = 100)
    @Column(name = "Uti_Prenom")
    private String prenom;

    @Column(name = "Uti_Statut")
    private Boolean Statut;

    @Size(max = 50)
    @Column(name = "Uti_Matricule")
    private String matricule;

    @Size(max = 50)
    @Column(name = "Uti_Fonction")
    private String fonction;

    @Column(name = "Uti_FirtsLog")
    private Boolean firstLog;

    @Column(name = "Uti_NewConnexion")
    private Boolean newConnexion;

    @Column(name = "Uti_DateInitPassword")
    private Date dateInitPassword;

    @Size(max = 150)
    @Column(name = "Uti_InitPassword")
    private String initPassword;

    @ManyToOne
    @JoinColumn(name = "Uti_Pro_Id")
    private Profil profil;

    @ManyToOne(optional = true)
    @JoinColumn(name = "Uti_Reg_Id")
    private RegieFinanciere regieFinanciere;

}
