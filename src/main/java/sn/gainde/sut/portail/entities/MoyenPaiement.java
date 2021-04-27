package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_MoyenPaiement")
public class MoyenPaiement implements Serializable {
    private static final long serialVersionUID = 8871869059957999293L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Moy_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Moy_Reference")
    private String reference;

    @Size(max = 100)
    @Column(name = "Moy_Libelle")
    private String libelle;

    @Column(name = "Moy_Description")
    private String description;

    @Column(name = "Moy_Statut")
    private Boolean Moy_Statut;

    @Size(max = 50)
    @Column(name = "Moy_Logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "Moy_Ope_Id")
    private Operateur operateur;

    @ManyToOne
    @JoinColumn(name = "Moy_Can_Id")
    private CanalPaiement canalPaiement;
}
