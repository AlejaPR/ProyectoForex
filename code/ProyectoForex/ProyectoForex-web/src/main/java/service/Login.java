package service;
import database.Mensaje;
import database.Usuario;
import interfaces.UsuarioControllerLocal;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase servicio del login
 */
@javax.enterprise.context.RequestScoped
@Path("login")
public class Login {
    
    /**Llado del bean usuario**/
    @EJB 
    UsuarioControllerLocal beanLogin;
    
    /**servicio login**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{usuario}/{clave}")
    public Response login(@PathParam("usuario") String usuarios, @PathParam("clave") String clave){
        System.out.println("Este usuario es:"+usuarios);
        Usuario usuario = new Usuario();
        usuario.setToken(beanLogin.loginUsuario(usuarios,clave));
        
        try {
            if(!usuario.getToken().equals("")){
            return Response.status(Response.Status.OK).entity(usuario).build();
            }else{
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }       
    }
}
