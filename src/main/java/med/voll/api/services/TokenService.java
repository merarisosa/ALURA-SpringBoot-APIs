package med.voll.api.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    String apiClave =  "123456";
    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiClave);
            return JWT.create()
                    .withIssuer("voll med ")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiClave);
            verifier = JWT.require(algorithm)
                    .withIssuer("voll med ")
                    .build().verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {

        }
        if(verifier.getSubject() == null){
            throw new RuntimeException("Verifier inválido!");
        }
        return verifier.getSubject();
    }
}
