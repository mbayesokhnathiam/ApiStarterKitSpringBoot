package com.azertysolutions.api.web.controller;

import com.azertysolutions.api.model.Utilisateur;
import com.azertysolutions.api.web.dto.model.UtilisateurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.azertysolutions.api.service.UtilisateurService;
import com.azertysolutions.api.web.dto.response.Response;


@RestController
@RequestMapping(value = "/api/v1/users/")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserController {

    /**
     * Injection de dépendance des services en utilsant lombok (RequiredArgsConstructor)
     * Les services doivent etre  déclarer en private final
     */
    private final UtilisateurService utilisateurService;

    /**
     *
     * @param page (la page actuel, par defaut c'est 0, c'est à dire la premiere pages)
     * @param size  ( le nombre de lignes à récupérer, par défaut c'est fixé à 10)
     * @return Response
     */
    @GetMapping("list")
    public Response<?> getListUsers(@RequestParam(value = "page",defaultValue = "0") int page,
                                          @RequestParam(value = "size",defaultValue = "10") int size){
        Page<Utilisateur> pages = utilisateurService.getListUtilisateurs(page, size);
        int newSize = pages.getSize();
        Long totalElements = pages.getTotalElements();
        int totalPages = pages.getTotalPages();
        int number = pages.getNumber();
        return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
    }

    /**
     *
     * @param user
     * @return Response
     */
    @PostMapping(value="/save")
    public Response<?> saveUser(@RequestBody Utilisateur user){
        Utilisateur saved = utilisateurService.saveUser(user);

        if(saved != null){
            return Response.ok().setPayload(saved).setMessage("Utilisateur crée avec succés!");
        }

        return Response.exception().setErrors("Une erreur est survenue");
    }

    /**
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value="update/{id}")
    public Response<?> updateUser(@PathVariable Long id, @RequestBody UtilisateurDto user){
        Utilisateur updated = utilisateurService.editUser(id,user);
        if(updated != null){
            return Response.ok().setPayload(updated).setMessage("Utilisateur mise à jour avec succés!");
        }

        return Response.exception().setErrors("Une erreur est survenue");


    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public Response<?> getUserByID(@PathVariable Long id){

        Utilisateur detail = utilisateurService.getUserById(id);

        if(detail != null){
            return Response.ok().setPayload(detail).setMessage("Informations utilisateurs!");
        }

        return Response.notFound().setErrors("Cet utilisateur n'existe pas!");


    }

    
}
