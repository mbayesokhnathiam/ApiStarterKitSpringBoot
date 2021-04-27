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
@Table(name = "TP_TypeDeclaration")
public class TypeDeclaration implements Serializable {
    private static final long serialVersionUID = -2692110923321959061L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tyd_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Tyd_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Tyd_Libelle")
    private String libelle;
}
