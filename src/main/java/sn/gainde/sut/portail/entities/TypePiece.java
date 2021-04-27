package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_TypePiece")
public class TypePiece implements Serializable {
    private static final long serialVersionUID = 2310979199762068309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Typ_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Typ_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Typ_Libelle")
    private String libelle;

    /*
    @OneToMany(mappedBy = "typePiece")
    private List<Declarant> declarants;

     */
}
