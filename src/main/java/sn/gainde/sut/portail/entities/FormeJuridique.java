package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_FormeJuridique")
public class FormeJuridique implements Serializable {
    private static final long serialVersionUID = -7834437285684089678L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Foj_Id")
    private Integer id;

    @Column(name = "Foj_Code")
    private String code;

    @Column(name = "Foj_Libelle")
    private String libelle;

    @OneToMany(mappedBy = "formeJuridique")
    private List<Contribuable> contribuables;
}
