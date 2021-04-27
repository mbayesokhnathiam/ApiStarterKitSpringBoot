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
@Table(name = "TP_Localite")
public class Localite implements Serializable {
    private static final long serialVersionUID = 4581332637110001791L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Loc_Id")
    private Integer id;

    @Column(name = "Loc_Code")
    private String code;

    @Column(name = "Loc_Libelle")
    private String libelle;

    @OneToMany(mappedBy = "localite")
    private List<Contribuable> contribuables;
}
