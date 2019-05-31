package seguridad;
import controller.UsuarioController;
import database.Usuario;
import database.consultas.ConsultasUsuario;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.digest.DigestUtils;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase seguridad que genera token con jwt 
 */
public class Seguridad {
    
    private static long tiempo = System.currentTimeMillis();
    private static long expiraToken = TimeUnit.MINUTES.toMillis(7200);
   
    /**metodo que genera el token**/
    public static String generarToken(String usuario, String clave){

        ConsultasUsuario consulta = new ConsultasUsuario();
        List<Usuario> listaUsuario = new ArrayList();
        listaUsuario = consulta.usuarioLogin(usuario, clave);
        for (Usuario usuarios : listaUsuario) {
            if(usuarios.getUsuario().equals(usuario) && usuarios.getClave().equals(clave)){
                 String token = Jwts.builder()
                                .setSubject(usuarios.getNombre())
                                .setIssuedAt(new Date(tiempo))
                                .setExpiration(new Date(tiempo+expiraToken))
                                .setIssuer(usuarios.getCorreo())
                                .signWith(SignatureAlgorithm.HS256,"A4J7A3prcc20")
                                .compact();
                 UsuarioController.editarToken(usuarios, token);
                 return token;
              }
        }
        return null;
        
        }
    
    /**metodo que desencripta el token**/
    public static String desencriptar(String token){
        Jws parseClaimJws = Jwts.parser().setSigningKey("A4J7A3prcc20").parseClaimsJws(token);
        System.out.println("Header   "+parseClaimJws.getHeader());
        System.out.println("Body     "+parseClaimJws.getBody());
        System.out.println("Signature   "+ parseClaimJws.getSignature());
        
        String tokencito = Jwts.parser().setSigningKey("A4J7A3prcc20").parseClaimsJws(token).getBody().getIssuer();
        
        return tokencito;  
    }
}
