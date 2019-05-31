package service;
import database.Usuario;
import database.consultas.ConsultasUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase que genera el filtro para el token
 */
@Provider
@PreMatching
public class Filtro implements ContainerRequestFilter{

@Override
 public void filter(ContainerRequestContext requestContext) throws IOException {
        String url=requestContext.getUriInfo().getAbsolutePath().toString();
        if(url.contains("api/login") || url.contains("api/usuario/registro")) 
            return;
        String token= requestContext.getHeaderString("TokenAuto");
        if(token==null){
            JsonObject json = Json.createObjectBuilder()
                    .add("token de usuario", "token requerido").build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
            .entity(json)
            .type(MediaType.APPLICATION_JSON)
            .build());  
        }else if(!token.equals(salvarToken(token))){
            JsonObject json = Json.createObjectBuilder()
                    .add("token de usuario", "token incorrecto").build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
            .entity(json)
            .type(MediaType.APPLICATION_JSON)
            .build());  
        }
       }

    
    private String salvarToken(String token){
        
        ConsultasUsuario consulta = new ConsultasUsuario();
        List<Usuario> listaUsuario = new ArrayList();
        listaUsuario= consulta.usuarioToken(token);
        String tokenVerificado="";
        for (Usuario usuarios : listaUsuario) {
              if(usuarios.getToken().equals(token)){
                  tokenVerificado = usuarios.getToken();
                  return tokenVerificado; 
              }
        }
        tokenVerificado = "Error";
        return tokenVerificado;
    }
}
