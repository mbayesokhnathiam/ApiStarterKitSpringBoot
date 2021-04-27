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
@Table(name = "TD_NotePerception")
public class NotePerception implements Serializable {
    private static final long serialVersionUID = -6311378184435647257L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Not_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Not_Reference")
    private String reference;

    @Column(name = "Not_Montant")
    private Double montant;

    @Column(name = "Not_MontantGlobaleAPayer")
    private Double montantGlobaleAPayer;

    @Column(name = "Not_MontantGlobalePayer")
    private Double montantGlobalePayer;

    @Column(name = "Not_Echeance")
    private Integer echeance;

    @Size(max = 50)
    @Column(name = "Not_Ninea")
    private String ninea;

    @Size(max = 150)
    @Column(name = "Not_RaisonSocialeOuNom")
    private String raisonSocialeOuNom;

    @Size(max = 150)
    @Column(name = "Not_Email")
    private String email;

    @Size(max = 50)
    @Column(name = "Not_Telephone")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "Not_Reg_Id")
    private RegieFinanciere regieFinanciere;

    @ManyToOne
    @JoinColumn(name = "Not_Dec_Id")
    private Declaration declaration;

    @ManyToOne
    @JoinColumn(name = "Not_Stp_Id")
    private StatutPaiement statutPaiement;

    @ManyToOne
    @JoinColumn(name = "Not_Con_Id")
    private Contribuable contribuable;
}
