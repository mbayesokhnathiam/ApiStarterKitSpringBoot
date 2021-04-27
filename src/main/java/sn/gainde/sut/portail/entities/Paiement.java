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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TD_Paiement")
public class Paiement implements Serializable {
    private static final long serialVersionUID = -6827688221868361165L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pai_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Pai_Not_Reference")
    private String referenceNotePerception;

    @Column(name = "Pai_Montant")
    private Double montant;

    @Size(max = 50)
    @Column(name = "Pai_Telephone")
    private String telephone;

    @Size(max = 50)
    @Column(name = "Pai_Iban")
    private String  iban;

    @Size(max = 50)
    @Column(name = "Pai_Moy_reference")
    private String referenceMoyenPaiement;

    @CreationTimestamp
    @Column(name = "Pai_DateInitialisationPaiement")
    private Date dateInitialisationPaiement;

    @Column(name = "Pai_DateValidationPaiement")
    private Date dateValidationPaiement;

    @Size(max = 50)
    @Column(name = "Pai_ReferencePaiement")
    private String referencePaiement;

    @Size(max = 50)
    @Column(name = "Pai_ReferenceOperateur")
    private String referenceOperateur;

    @ManyToOne
    @JoinColumn(name = "Pai_Sta_Id")
    private StatutPaiement statutPaiement;

    @ManyToOne
    @JoinColumn(name = "Pai_Tpp_Id")
    private TypePaiement typePaiement;


    @ManyToOne
    @JoinColumn(name = "Pai_Ope_Reference")
    private Operateur operateur;
}
