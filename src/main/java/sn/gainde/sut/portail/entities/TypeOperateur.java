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
@Table(name = "TP_TypeOperateur")
public class TypeOperateur implements Serializable {
    private static final long serialVersionUID = -5738256064658419791L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tyo_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Tyo_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Tyo_Libelle")
    private String libelle;
}
