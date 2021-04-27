package sn.gainde.sut.portail.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;
import sn.gainde.sut.portail.implementation.UtilisateurServiceImpl;
import sn.gainde.sut.portail.security.jwt.JwtProvider;
import sn.gainde.sut.portail.security.services.UserDetailsServiceImpl;
import sn.gainde.sut.portail.web.dto.model.LoginForm;
import sn.gainde.sut.portail.web.dto.response.JwtResponse;
import sn.gainde.sut.portail.web.dto.response.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
   @Autowired
   UtilisateurServiceImpl utilisateurService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/signin")
    public Response<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String accessToken = jwtProvider.generateJwtToken(authentication).get("access-token");
            String refreshToken = jwtProvider.generateJwtToken(authentication).get("refresh-token");
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println(accessToken);

            return Response.ok().setPayload(JwtResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .username(userDetails.getUsername())
                    .authorities(userDetails.getAuthorities()).build());
        } catch (AuthenticationException e) {
            System.out.println();
            return Response.wrongCredentials().setErrors("Vos identifiants sont incorrects");
        }
    }


    @GetMapping("/refresh")
    public Response<?> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String refreshJwtToken = getJwt(request);
            if (refreshJwtToken != null && jwtProvider.validateJwtToken(refreshJwtToken)) {
                //on extrait les infos de l'utilisateur
                String username = jwtProvider.getUserNameFromJwtToken(refreshJwtToken);

                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //on crée une Authentication token
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String accessToken = jwtProvider.generateJwtToken(authentication).get("access-token");
                return Response.ok().setPayload(
                        JwtResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshJwtToken)
                        .username(userDetails.getUsername())
                        .authorities(userDetails.getAuthorities()).build());

            }
            else
                return Response.exception().setErrors("Une erreur est servenue");
        } catch (Exception e) {
            System.out.println("token invalide");
            //logger.error("Impossible de définir l'authentification utilisateur -> Message: {}", e);
            return Response.exception().setErrors("Le token est invalide");
        }
    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }

}
