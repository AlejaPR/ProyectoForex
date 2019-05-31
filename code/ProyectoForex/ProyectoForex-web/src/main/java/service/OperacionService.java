package service;
import database.Mensaje;
import database.Operacion;
import interfaces.OperacionControllerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
 * Clase servicio de operacion
 */
@javax.enterprise.context.RequestScoped
@Path("operacion")
public class OperacionService {
    
    /**Llamado del bean de operacion**/
    @EJB
    OperacionControllerLocal beanOperacion;
    
    /**servicio post que registra la operacion**/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registrOpe/{token}")
    public Response registrarOperacion(@PathParam("token") String token, Operacion operacion){
        System.out.println("Divisa:"+operacion.getDivisa());
        
        String mensajes= beanOperacion.registrarOperacion(operacion);
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
            return Response.status(Response.Status.BAD_REQUEST).entity(operacion).build();
        }     
    }
    /**servicio get que trae todas las operaciones**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/operaciones/{token}")
    public Response traerOperacioes(@PathParam("token") String token){
        try{
                return Response.status(Response.Status.OK).entity(beanOperacion.traerOperaciones(token)).build(); 
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    
    /**servicio get que cierra las operaciones**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idoperacion}/{token}")
    public Response cerrarOperacion(@PathParam("idoperacion") Integer idoperacion,@PathParam("token") String token){
        try{
            System.out.println(token);
            Operacion o = new Operacion();
            o.setValidaroperacion(beanOperacion.cerrarOperacion(idoperacion,token));
            
            if(o.isValidaroperacion()==true){
                 return Response.status(Response.Status.OK).entity(o).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(o).build();
            }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    
    /**servicio get que trae las operacones de historial**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/historial/{token}")
    public Response traerHistorial(@PathParam("token") String token){
        try{
            System.out.println(token);
            List<Operacion> listaOperaciones = new ArrayList();
            listaOperaciones = beanOperacion.traerHistorial(token);
            
            
                return Response.status(Response.Status.OK).entity(listaOperaciones).build();
            
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    
    /**servicio que cambia las divisa en la tabla operaciones**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cambiar/{token}")
    public Response cambiarDivisa(@PathParam("token") String token){
        try{
                System.out.println("cambiar");
                return Response.status(Response.Status.OK).entity(beanOperacion.cambiarValorActual(token)).build(); 
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    
    /**servicio que cambia el saldo en la tabla operaciones**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saldo/{token}")
    public Response cambiarSaldo(@PathParam("token") String token){
        try{
               System.out.println("saldo");
              
               int a = beanOperacion.cambiarSaldo(token);
                return Response.status(Response.Status.OK).entity(a).build(); 
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
}
