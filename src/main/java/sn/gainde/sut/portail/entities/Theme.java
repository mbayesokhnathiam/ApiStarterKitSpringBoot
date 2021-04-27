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
@Table(name = "TP_Theme")
public class Theme implements Serializable {
    private static final long serialVersionUID = 2558538714603782209L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "The_Id")
    private Integer id;

    @Size(max = 20)
    @Column(name = "The_Code")
    private String code;

    @Size(max = 100)
    @Column(name = "The_Libelle")
    private String libelle;
}
