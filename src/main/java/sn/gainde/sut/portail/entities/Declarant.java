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
@Entity
@Table(name = "TD_Declarant")
public class Declarant extends Utilisateur implements Serializable{
    private static final long serialVersionUID = 6005541213765221931L;

    @Size(max = 150)
    @Column(name = "Dec_NumIdentifiant")
    private String numIdentifiant;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Dec_Con_Id")
    private Contribuable contribuable;

    @ManyToOne
    @JoinColumn(name = "Dec_Typ_Id")
    private TypePiece typePiece;

    @Column(name = "Dec_IdDeclarant")
    private Integer idDeclarant;
}
