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
@Table(name = "TP_Operateur")
public class Operateur implements Serializable {
    private static final long serialVersionUID = 4637037643568248226L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ope_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Ope_Reference")
    private String reference;

    @Size(max = 50)
    @Column(name = "Ope_Ninea", unique = true)
    private String ninea;

    @Size(max = 50)
    @Column(name = "Ope_Nom")
    private String nom;

    @Column(name = "Ope_Description")
    private String description;

    @Column(name = "Ope_Statut")
    private Boolean statut;

    @Column(name = "Ope_Logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "Ope_Tyo_Id")
    private TypeOperateur typeOperateur;
}
