package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_Suggestion")
public class Suggestion implements Serializable {
    private static final long serialVersionUID = 74041711770303356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sug_Id")
    private Integer id;

    @Column(name = "Sug_Description")
    private String  description;

    @Column(name = "Sug_DateCreation")
    private Date dateCreation;

    @Column(name = "Sug_Statut")
    private Boolean statut;

    @ManyToOne
    @JoinColumn(name = "Sug_The_Id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "Sug_Con_Id")
    private Contribuable contribuable;
}
