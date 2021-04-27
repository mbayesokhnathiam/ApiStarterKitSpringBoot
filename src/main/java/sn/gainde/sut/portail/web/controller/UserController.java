package sn.gainde.sut.portail.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.gainde.sut.portail.entities.Utilisateur;
import sn.gainde.sut.portail.services.UtilisateurService;
import sn.gainde.sut.portail.web.dto.model.UtilisateurDto;
import sn.gainde.sut.portail.web.dto.response.Response;


@RestController
@RequestMapping(value = "/api/v1/users/")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserController {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("list")
   // @PostAuthorize("hasAnyAuthority('EMPLOYE')")
    public Response<?> getListUsers(@RequestParam(value = "page",defaultValue = "0") int page,
                                    @RequestParam(value = "size",defaultValue = "10") int size){

        Page<Utilisateur> pages = utilisateurService.getListUtilisateurs(page, size);
        int newSize = pages.getSize();
        Long totalElements = pages.getTotalElements();
        int totalPages = pages.getTotalPages();
        int number = pages.getNumber();
        return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));

    }
    
    @PostMapping(value="/save")
    //@PostAuthorize("hasAnyAuthority('ADMIN')")
    public Response<?> saveUser(@RequestBody Utilisateur user){
        user.setPassword(passwordEncoder.encode("Passer1234"));
        Utilisateur saved = utilisateurService.saveUser(user);

        if(saved != null){
            Page<Utilisateur> pages = utilisateurService.getListUtilisateurs(0, 10);
            int newSize = pages.getSize();
            Long totalElements = pages.getTotalElements();
            int totalPages = pages.getTotalPages();
            int number = pages.getNumber();
            return Response.ok().setPayload(saved).setMessage("Utilisateur ajouté avec succès").setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
        }

        return Response.exception().setErrors("Une erreur est survenue");
    }

    @PutMapping(value="update/{id}")
    //@PostAuthorize("hasAnyAuthority('ADMIN')")
    public Response<?> updateUser(@PathVariable Integer id, @RequestBody UtilisateurDto user){

        System.out.println("----------------update--------------------");
        Utilisateur updated = utilisateurService.editUser(id,user);

        if(updated != null){
            Page<Utilisateur> pages = utilisateurService.getListUtilisateurs(0, 10);
            int newSize = pages.getSize();
            Long totalElements = pages.getTotalElements();
            int totalPages = pages.getTotalPages();
            int number = pages.getNumber();
            return Response.ok().setPayload(updated).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
        }

        return Response.exception().setErrors("Une erreur est survenue");


    }

    @GetMapping(value="/{id}")
    //@PostAuthorize("hasAnyAuthority('EMPLOYE')")
    public Response<?> getUserByID(@PathVariable Integer id){

        Utilisateur detail = utilisateurService.getUserById(id);

        if(detail != null){
            return Response.ok().setPayload(detail).setMessage("Informations utilisateurs!");
        }

        return Response.notFound().setErrors("Cet utilisateur n'existe pas!");


    }

    
}
