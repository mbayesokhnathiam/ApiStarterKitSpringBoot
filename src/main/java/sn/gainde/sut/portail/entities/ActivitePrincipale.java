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
@Table(name = "TP_ActivitePrincipale")
public class ActivitePrincipale implements Serializable {
    private static final long serialVersionUID = -1758863593922302877L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Act_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Act_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Act_Libelle")
    private String libelle;

    @OneToMany(mappedBy = "activitePrincipale")
    private List<Contribuable> contribuables;

}
