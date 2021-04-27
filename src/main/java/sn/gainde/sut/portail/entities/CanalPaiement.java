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
@Table(name = "TP_CanalPaiement")
public class CanalPaiement implements Serializable {
    private static final long serialVersionUID = 8027589498244487525L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Can_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Can_Reference")
    private String reference;

    @Size(max = 100)
    @Column(name = "Can_Libelle")
    private String libelle;

    @Column(name = "Can_Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "Can_Mod_Id")
    private ModePaiement modePaiement;
}
