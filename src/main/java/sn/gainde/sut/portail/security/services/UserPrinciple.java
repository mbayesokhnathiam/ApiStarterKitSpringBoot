package sn.gainde.sut.portail.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sn.gainde.sut.portail.entities.Utilisateur;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
- UserPrinciple mettra en œuvre UserDetails .
UserPrinciple n' est pas utilisé directement par Spring Security à des ns de
sécurité.
Il stocke simplement les informations utilisateur qui sont ensuite encapsulées
dans des Authentication objets. Cela permet de stocker des informations
utilisateur non liées à la sécurité (telles que les adresses e-mail, les numéros de
téléphone, etc.).
 */
public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    //Renvoie les droits accordés à l'utilisateur. Impossible de revenir null.
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Integer id, String name,
                         String username, String email, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrinciple build(Utilisateur utilisateur) {
        List<GrantedAuthority> authorities = Arrays.asList(utilisateur.getProfil()).stream().map(role ->
                new SimpleGrantedAuthority(role.getCode())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                utilisateur.getId(),
                utilisateur.getPrenom(),
                utilisateur.getEmail(),
                utilisateur.getEmail(),
                utilisateur.getPassword(),
                authorities
        );
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    //Indique si le compte de l'utilisateur a expiré. Un compte expiré ne peut pas être authentifié.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Indique si l'utilisateur est verrouillé ou déverrouillé. Un utilisateur verrouillé ne peut pas être authentifié.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //Indique si les informations d'identification (mot de passe) de l'utilisateur ont expiré.
    // Les informations d'identification expirées empêchent l'authentification.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Indique si l'utilisateur est activé ou désactivé. Un utilisateur désactivé ne peut pas être authentifié.
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}