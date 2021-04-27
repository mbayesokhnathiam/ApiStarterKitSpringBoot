package sn.gainde.sut.portail.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TD_Incident")
public class Incident implements Serializable {
    private static final long serialVersionUID = -5632282360586328766L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Inc_Id")
    private Integer id;

    @Column(name = "Inc_Description")
    private String description;

    @Size(max = 50)
    @Column(name = "Inc_Reference")
    private String reference;

    @CreationTimestamp
    @Column(name = "Inc_DateCreation")
    private Date dateCreation;

    @Size(max = 20)
    @Column(name = "Inc_DateTraitement")
    private Date dateTraitement;

    @ManyToOne
    @JoinColumn(name = "Inc_Not_Id")
    private NotePerception notePerception;

    @ManyToOne
    @JoinColumn(name = "Inc_Tpe_Id")
    private TypeDemande typeDemande;

    @ManyToOne
    @JoinColumn(name = "Inc_Stt_Id")
    private StatutIncident statutIncident;

    @ManyToOne
    @JoinColumn(name = "Inc_Uti_IdValidateur")
    private Utilisateur utilisateur;
}
