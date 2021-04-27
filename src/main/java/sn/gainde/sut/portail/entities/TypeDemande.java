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
@Table(name = "TP_TypeDemande")
public class TypeDemande implements Serializable {
    private static final long serialVersionUID = -6400115326888152261L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Stt_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Stt_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Stt_Libelle")
    private String libelle;
}
