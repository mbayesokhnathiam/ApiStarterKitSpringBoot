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
@Table(name = "TP_TypePaiement")
public class TypePaiement implements Serializable {
    private static final long serialVersionUID = -2559943745486823584L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tpp_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Tpp_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Tpp_Libelle")
    private String libelle;
}
