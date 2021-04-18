package sn.gainde.api.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sn.gainde.api.model.Utilisateur;
import sn.gainde.api.service.UtilisateurService;
import sn.gainde.api.web.dto.response.Response;


@RestController
@RequestMapping(value = "/api/v1/users/")
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
        boolean status = utilisateurService.saveUser(user);

        if(status){
            return Response.ok().setMessage("Utilisateur envoyer avec succes!");
        }

        return Response.exception().setErrors("Une erreur est survenue");
    }

    @PutMapping(value="update/{id}")
    public Response<?> updateUser(@RequestBody Utilisateur user){
        return null;
    }

    
}
