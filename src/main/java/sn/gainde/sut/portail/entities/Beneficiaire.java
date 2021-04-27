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
@Table(name = "TP_Beneficiaire")
public class Beneficiaire implements Serializable {
    private static final long serialVersionUID = -1943475165133933161L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ben_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Ben_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Ben_Libelle")
    private String libelle;
}
