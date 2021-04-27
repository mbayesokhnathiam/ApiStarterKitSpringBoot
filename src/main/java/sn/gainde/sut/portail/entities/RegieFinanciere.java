package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_RegieFinanciere")
public class RegieFinanciere implements Serializable {
    private static final long serialVersionUID = -6150737839457174480L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reg_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Reg_Reference")
    private String reference;

    @Size(max = 100)
    @Column(name = "Reg_Libelle")
    private String libelle;

    @Size(max = 100)
    @Column(name = "Reg_Telephone")
    private String telephone;

    @Size(max = 150)
    @Column(name = "Reg_AdresseMail")
    private String adresseMail;

    @Column(name = "Reg_Description")
    private String description;

    @Size(max = 150)
    @Column(name = "Reg_Logo")
    private String logo;

    @OneToMany(mappedBy = "regieFinanciere", fetch = FetchType.LAZY)
    private Set<Utilisateur> utilisateurs;
}
