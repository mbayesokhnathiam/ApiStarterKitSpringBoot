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
@Table(name = "TD_Faq")
public class Faq implements Serializable {
    private static final long serialVersionUID = -1093216085020379422L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Faq_Id")
    private Integer id;

    @Column(name = "Faq_Question")
    private String question;

    @Column(name = "Faq_Reponse")
    private String reponse;

    @Column(name = "Faq_Statut")
    private Boolean statut;

    @Column(name = "Faq_DateCreation")
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "Faq_The_Id")
    private Theme theme;
}
