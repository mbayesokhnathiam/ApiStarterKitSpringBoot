package sn.gainde.api.security.jwt.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// cette filtre les requetes pour voir si on est autorise
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    // cette methode s'execute a chaque fois qu'on a une requte
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // pour chaque requete qui arrive on lit le header des autorisations
        if(request.getServletPath().equals("/refreshToken")){
            filterChain.doFilter(request, response);
        }
        else {
            String authorizationToken = request.getHeader("Authorization");
            // si l'autorisation existe il doit commencer par la chaine "Bearer "
            if (authorizationToken != null && authorizationToken.startsWith("Bearer ")){
                try{
                    // on recupere le token excepte la chaine "Bearer "
                    String jwt = authorizationToken.substring(7);

                    // on doit signer le jwt pour verifier s'il est valable
                    Algorithm algorithm = Algorithm.HMAC256("mySecret123456");
                    JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = jwtVerifier.verify(jwt);

                    // si le token est valide on recup les donnees du token
                    String login = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);

                    // on va maintenant authentifier le user
                    Collection<GrantedAuthority> authorities = new ArrayList<>();
                    for (String role :roles){
                        authorities.add(new SimpleGrantedAuthority(role));
                    }
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    // pour lui dire de passer au filtre suivant
                    filterChain.doFilter(request, response);
                } catch (Exception e) {
                    System.out.println("dans le catch");
                    response.setHeader("error-message", e.getMessage());
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                }
            }
            else{
                System.out.println("Bearer absent");
                filterChain.doFilter(request, response);
            }
        }

    }
}
