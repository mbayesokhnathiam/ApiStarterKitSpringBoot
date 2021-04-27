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
@Table(name = "TP_StatutIncident")
public class StatutIncident implements Serializable {
    private static final long serialVersionUID = -2150089716045734164L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Tpe_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Tpe_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Tpe_Libelle")
    private String libelle;
}
