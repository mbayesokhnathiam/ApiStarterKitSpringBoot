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
@Table(name = "TP_StatutInscription")
public class StatutInscription implements Serializable {
    private static final long serialVersionUID = -3956327579472678093L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sti_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Sti_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Sti_Libelle")
    private String libelle;

    @OneToMany(mappedBy = "statutInscription")
    private List<Contribuable> contribuables;
}
