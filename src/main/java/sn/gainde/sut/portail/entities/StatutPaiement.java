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
@Table(name = "TP_StatutPaiement")
public class StatutPaiement implements Serializable {
    private static final long serialVersionUID = -5308939124004032668L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sta_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Sta_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Sta_Libelle")
    private String libelle;
}
