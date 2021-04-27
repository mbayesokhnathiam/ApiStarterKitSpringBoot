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
@Table(name = "TP_Declaration")
public class Declaration implements Serializable {
    private static final long serialVersionUID = 8027589498244487525L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dec_Id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "Dec_Reference")
    private String reference;

    @CreationTimestamp
    @Column(name = "Dec_DateCreation")
    private Date dateCreation;

    @Size(max = 100)
    @Column(name = "Dec_Libelle")
    private String libelle;

    @Column(name = "Dec_Description")
    private String description;

    @Column(name = "Dec_Statut")
    private Boolean statut;

    @ManyToOne
    @JoinColumn(name = "Dec_Tyd_Id")
    private TypeDeclaration typeDeclaration;

    @ManyToOne
    @JoinColumn(name = "Dec_Reg_Id")
    private RegieFinanciere regieFinanciere;
}
