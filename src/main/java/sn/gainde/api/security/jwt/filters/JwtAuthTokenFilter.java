package sn.gainde.api.security.jwt.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import sn.gainde.api.security.jwt.JwtProvider;
import sn.gainde.api.security.services.UserDetailsServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
- JwtAuthTokenFilter s' étend OncePerRequestFilter .
org.springframework.web.filter.OncePerRequestFilter s' exécute une fois
par requête. Il s' agit d' une classe de base de ltre utilisée pour garantir une
exécution unique par envoi de requête. Il fournit une méthode doFilterInternal
avec HttpServletRequest et des HttpServletResponse arguments.
À l' intérieur de la JwtAuthTokenFilter classe, la doFilterInternal méthode:
* obtenir le jeton JWT de l' en-tête
* valider JWT
* analyser le nom d' utilisateur à partir du JWT validé
* charger les données de la table des utilisateurs, puis créer un objetd' authentication
* définir l' objet d' authentication sur contexte de sécurité
 */
// cette filtre les requetes pour voir si on est autorise
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
    @Autowired
    private JwtProvider tokenProvider;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // cette methode s'execute a chaque fois qu'on a une requte
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // pour chaque requete qui arrive on lit le header des autorisations


            if(request.getServletPath().equals("/refreshToken")){
                System.out.println("refresh token de doFilterInternal");
                filterChain.doFilter(request, response);
            }
            else {
                try {
                String jwt = getJwt(request);
                String refreshJwtToken = getRefreshJwt(request);
                    if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
                    //on extrait les infos de l'utilisateur
                    String username = tokenProvider.getUserNameFromJwtToken(jwt);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    //on crée une Authentication token
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                        System.out.println("access correct 1");

                        // on regenere un nouveau token
                        System.out.println("refresh bi migui ni");
                        System.out.println(refreshJwtToken);
                    if (refreshJwtToken != null && tokenProvider.validateJwtToken(refreshJwtToken)) {
                        System.out.println("refresh correct 1");
                        System.out.println("yekcina");
                        //on extrait les infos de l'utilisateur
                        String usernameFromFromRefresh = tokenProvider.getUserNameFromJwtToken(refreshJwtToken);

                        UserDetails userDetailsFromRefresh = userDetailsService.loadUserByUsername(usernameFromFromRefresh);
                        //on crée une Authentication token
                        UsernamePasswordAuthenticationToken authenticationFromRefresh = new UsernamePasswordAuthenticationToken(
                                userDetailsFromRefresh, null, userDetailsFromRefresh.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authenticationFromRefresh);
                        String accessToken = tokenProvider.generateJwtToken(authenticationFromRefresh).get("access-token");

                        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                        httpServletResponse.addHeader(
                                "accessToken", accessToken);
                    }
                }
            } catch (Exception e) {
                System.out.println("token invalide");
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token invalide");
                //logger.error("Impossible de définir l'authentification utilisateur -> Message: {}", e);
            }

            filterChain.doFilter(request, response);
            }

    }

    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }

    private String getRefreshJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("RefreshToken");

        if (authHeader != null && authHeader.startsWith("refresh ")) {
            return authHeader.replace("refresh ", "");
        }

        return null;
    }
}