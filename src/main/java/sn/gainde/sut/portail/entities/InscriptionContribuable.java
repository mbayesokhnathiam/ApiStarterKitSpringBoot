package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TD_InscriptionContribuable")
public class InscriptionContribuable implements Serializable {
    private static final long serialVersionUID = -6180044929905236043L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ins_Id")
    private Integer id;

    @Column(name = "Ins_DateInscription")
    private Date dateInscription;

    @Column(name = "Ins_DateTraitementInscription")
    private Date dateTraitementInscription;

    @Column(name = "Ins_MotifTraitementInscription")
    private String motifTraitementInscription;

    @Size(max = 50)
    @Column(name = "Ins_Ninea")
    private String ninea;

    @Size(max = 150)
    @Column(name = "Ins_RaisonSocialeOuNom")
    private String raisonSocialeOuNom;

    @Size(max = 150)
    @Column(name = "Ins_Adresse")
    private String adresse;

    @Size(max = 100)
    @Column(name = "Ins_NomDeclarant")
    private String nomDeclarant;

    @Size(max = 150)
    @Column(name = "Ins_PrenomDeclarant")
    private String prenomDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_EmailDeclarant")
    private String emailDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_TelephoneDeclarant")
    private String telephoneDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_NumIdentifiantDeclarant")
    private String numIdentifiantDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_NomAssistantDeclarant")
    private String nomAssistantDeclarant;

    @Size(max = 150)
    @Column(name = "Ins_PrenomAssistantDeclarant")
    private String prenomAssistantDeclarant;

    @Size(max = 150)
    @Column(name = "Ins_EmailAssistantDeclarant")
    private String emailAssistantDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_TelephoneAssistantDeclarant")
    private String telephoneAssistantDeclarant;

    @Size(max = 100)
    @Column(name = "Ins_NumIdentifiantAssistantDeclarant")
    private String numIdentifiantAssistantDeclarant;

    @ManyToOne
    @JoinColumn(name = "Ins_Foj_Id")
    private FormeJuridique formeJuridique;

    @ManyToOne
    @JoinColumn(name = "Ins_Loc_Id")
    private Localite localite;

    @ManyToOne
    @JoinColumn(name = "Ins_Act_Id")
    private ActivitePrincipale activitePrincipale;

    @ManyToOne
    @JoinColumn(name = "Ins_Tye_Id")
    private TypeEntite typeEntite;

    @ManyToOne
    @JoinColumn(name = "Ins_Typ_IdDeclarant")
    private TypePiece typePieceDeclarant;

    @ManyToOne
    @JoinColumn(name = "Ins_Typ_IdAssistantDeclarant")
    private TypePiece typePieceAssistantDeclarant;

    @ManyToOne
    @JoinColumn(name = "Ins_Uti_Id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "Ins_Sti_Id")
    private StatutInscription statutInscription;
}
