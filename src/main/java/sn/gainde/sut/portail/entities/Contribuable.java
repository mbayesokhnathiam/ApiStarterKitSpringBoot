package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tp_menu_item")
public class Contribuable implements Serializable {
    private static final long serialVersionUID = -5905486217924976662L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Con_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Con_Ninea", unique = true)
    private String ninea;

    @Size(max = 150)
    @Column(name = "Con_RaisonSocialeOuNom")
    private String raisonSocialeOuNom;

    @Size(max = 150)
    @Column(name = "Con_Adresse")
    private String adresse;

    @CreationTimestamp
    @Column(name = "Con_DateInscription")
    private Date dateInscription;

    @Column(name = "Con_DateValidation")
    private Date dateValidation;

    @Column(name = "Con_Solde")
    private Double solde;

    @ManyToOne
    @JoinColumn(name = "Con_Foj_Id")
    private FormeJuridique formeJuridique;

    @ManyToOne
    @JoinColumn(name = "Con_Loc_Id")
    private Localite localite;

    @ManyToOne
    @JoinColumn(name = "Con_Act_Id")
    private ActivitePrincipale activitePrincipale;

    @ManyToOne
    @JoinColumn(name = "Con_Tye_Id")
    private TypeEntite typeEntite;

    @ManyToOne
    @JoinColumn(name = "Con_Sti_Id")
    private StatutInscription statutInscription;

    @OneToMany(mappedBy = "contribuable")
    private List<Declarant> declarants;
}
