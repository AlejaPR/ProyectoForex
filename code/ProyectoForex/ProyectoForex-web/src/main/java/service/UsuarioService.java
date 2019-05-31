package service;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import database.Mensaje;
import database.Usuario;
import interfaces.UsuarioControllerLocal;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
 * Clase servicio de usuario
 */
@javax.enterprise.context.RequestScoped
@Path("usuario")
public class UsuarioService {
    
    /**Llamado del bean de usuario**/
    @EJB 
    UsuarioControllerLocal beanPrueba;
   
    /**servicio que agrega usuario**/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registro")
    public Response agregar(Usuario usuarios){
        System.out.println("Este usuario es:"+usuarios.getNombre());
        
        String mensajes= beanPrueba.registrarUsuario(usuarios);
        try {
            if(mensajes.equals("")){
                System.out.println("Agregado");
                Mensaje mensaje= new Mensaje();
                mensaje.setMensajes("Registro correcto");
                return Response.status(Response.Status.OK).entity(mensaje).build();
            }else{
               Mensaje mensaje= new Mensaje();
               mensaje.setMensajes("Datos incorrectos");
             return Response.status(Response.Status.OK).entity(mensaje).build();
            } 
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarios).build();
        }     
    }
    
    /**servicio que devuelve los datos del usuario**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}")
    public Response devolverUsuario(@PathParam("token") String token){
        try {
            System.out.println(token);
            Usuario u =beanPrueba.devolverUsuario(token);
            System.out.println(u.getNombre());
            return Response.status(Response.Status.OK).entity(u).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }     
    }
    
    /**servicio que cierra sesion**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cerrar/{token}")
    public Response cerrarSesion(@PathParam("token") String token){
        try {
            System.out.println(token);
            int u =beanPrueba.cerrarSesion(token);
            
            if(u==1){
                return Response.status(Response.Status.OK).entity(u).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(u).build();
            }
            
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }     
    }
}
