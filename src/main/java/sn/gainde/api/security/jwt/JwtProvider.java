package sn.gainde.api.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import sn.gainde.api.security.services.UserPrinciple;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
- JwtProvider est une classe util -> il implémente des fonctions utiles:
générer un jeton JWT
valider un jeton JWT
analyser le nom d' utilisateur du jeton JWT
 */
@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${loizenai.app.jwtSecret}")
    private String jwtSecret;

    @Value("${loizenai.app.jwtExpiration}")
    private int jwtExpiration;

    public Map<String, String> generateJwtToken(Authentication authentication) {

        //l'utilisateur courant qui s'est authentifié
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        Long deb = new Date().getTime();
        Long fin = new Date().getTime() + jwtExpiration*1000;
        Long duration = fin-deb;
        System.out.println(deb);
        System.out.println(fin);
        System.out.println(duration);
        System.out.println(new Date(deb));
        System.out.println(new Date(fin));
        System.out.println(new Date(duration));
        System.out.println(new Date(System.currentTimeMillis()+ jwtExpiration*60*1000));
        System.out.println(new Date(System.currentTimeMillis()+ (jwtExpiration + 10)*60*1000));
        String jwtAccessToken = Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ jwtExpiration*60*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("test", "test");
        String jwtRefreshToken = Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ (jwtExpiration + 3600)*60*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        Map<String, String> idToken = new HashMap<>();
        idToken.put("access-token", jwtAccessToken);
        idToken.put("refresh-token", jwtRefreshToken);

        // on va envoyer l'objet au format json dans le corps de la response

        return idToken;

    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("La signature du JWT est invalide -> Message: {}");
            //logger.error("Signature JWT non valide -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("Le format du JWT est incorrect -> Message: {}");
            //logger.error("Jeton JWT non valide -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Le jeton JWT a expiré -> Message: {}");
            //logger.error("Jeton JWT expiré -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Le format du jeton JWT n'est pris en charge -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("La chaîne de réclamation JWT est vide -> Message: {}", e);
        }

        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}