package service;
import database.Divisa;
import interfaces.DivisaControllerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase divisa servicio
 */
@javax.enterprise.context.RequestScoped
@Path("divisa")
public class DivisaService {
    
    /**Llamado del bean de divisa**/
    @EJB 
    DivisaControllerLocal beanDivisa;
    
    /**servicio que cambia la divisa uno**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/divisa1/valor/{token}")
    public Response cambiarDivisa1(@PathParam("token") String token){
        try{
            System.out.println(token);
            Divisa d = new Divisa();
            d.setValorandom(beanDivisa.cambiarDivisa1(token));
            if(d.getValorandom().equals(1)){
                return Response.status(Response.Status.OK).entity(beanDivisa.traerDivisa1(token)).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(d).build();
            }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }  
    }
    
    /**servicio que cambia la divisa dos**/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/divisa2/valor/{token}")
    public Response cambiarDivisa2(@PathParam("token") String token){
        try{
            System.out.println(token);
            Divisa d = new Divisa();
            d.setValorandom(beanDivisa.cambiarDivisa2(token));
            
            if(d.getValorandom().equals(1)){
                return Response.status(Response.Status.OK).entity(beanDivisa.traerDivisa2(token)).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(d).build();
            }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
}
