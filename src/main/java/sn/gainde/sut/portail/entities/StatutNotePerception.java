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
@Table(name = "TP_StatutNotePerception")
public class StatutNotePerception implements Serializable {
    private static final long serialVersionUID = -575502434883975801L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Stp_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "Stp_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "Stp_Libelle")
    private String libelle;
}
