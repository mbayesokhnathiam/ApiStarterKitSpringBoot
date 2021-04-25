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

    private final UtilisateurService utilisateurService;

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
    
    @PostMapping(value="/save")
    public Response<?> saveUser(@RequestBody Utilisateur user){
        Utilisateur saved = utilisateurService.saveUser(user);

        if(saved != null){
            Page<Utilisateur> pages = utilisateurService.getListUtilisateurs(0, 10);
            int newSize = pages.getSize();
            Long totalElements = pages.getTotalElements();
            int totalPages = pages.getTotalPages();
            int number = pages.getNumber();
            return Response.ok().setPayload(saved).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
        }

        return Response.exception().setErrors("Une erreur est survenue");
    }

    @PutMapping(value="update/{id}")
    public Response<?> updateUser(@PathVariable Long id, @RequestBody UtilisateurDto user){
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
    public Response<?> getUserByID(@PathVariable Long id){

        Utilisateur detail = utilisateurService.getUserById(id);

        if(detail != null){
            return Response.ok().setPayload(detail).setMessage("Informations utilisateurs!");
        }

        return Response.notFound().setErrors("Cet utilisateur n'existe pas!");


    }

    
}