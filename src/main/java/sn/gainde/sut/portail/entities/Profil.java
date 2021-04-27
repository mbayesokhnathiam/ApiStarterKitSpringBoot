package sn.gainde.sut.portail.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author MTHIAM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TP_Profil")
public class Profil implements Serializable {
    private static final long serialVersionUID = -6357628752964125571L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Pro_Id", unique = true, nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Pro_Libelle")
    private String libelle;

    @Size (max = 20)
    @Column(name = "Pro_Code")
    private String code;

    @OneToMany(mappedBy = "profil")
    @JsonIgnore
    private Set<Utilisateur> utilisateurs;

    public Profil(Integer id) {
        this.id = id;
    }


}

