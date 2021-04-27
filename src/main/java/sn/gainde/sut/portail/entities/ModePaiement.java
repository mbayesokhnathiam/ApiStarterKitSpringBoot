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
@Table(name = "TP_ModePaiement")
public class ModePaiement implements Serializable {
    private static final long serialVersionUID = 2260790568724551694L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Mod_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Mod_Reference")
    private String reference;

    @Size(max = 100)
    @Column(name = "Mod_Libelle")
    private String libelle;

    @Column(name = "Mod_Description")
    private String description;
}
