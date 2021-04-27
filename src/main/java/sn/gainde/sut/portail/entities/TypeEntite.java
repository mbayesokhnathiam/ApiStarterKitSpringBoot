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
@Table(name = "TP_TypeEntite")
public class TypeEntite implements Serializable {
    private static final long serialVersionUID = -1731405852571406176L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tye_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Tye_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Tye_Libelle")
    private String libelle;

    @OneToMany(mappedBy = "typeEntite")
    private List<Contribuable> contribuables;
}
