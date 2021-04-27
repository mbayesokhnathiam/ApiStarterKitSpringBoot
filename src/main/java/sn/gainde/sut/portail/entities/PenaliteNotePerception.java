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
@Table(name = "TD_PenaliteNotePerception")
public class PenaliteNotePerception implements Serializable {
    private static final long serialVersionUID = 7871724284858434792L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pen_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Pen_Reference")
    private String reference;

    @Column(name = "Pen_Montant")
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "Pen_Not_Id")
    private NotePerception notePerception;
}
