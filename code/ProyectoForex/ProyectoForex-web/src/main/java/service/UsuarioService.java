/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import database.Usuario;
import interfaces.UsuarioControllerLocal;
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
 * @author aleja
 */
@javax.enterprise.context.RequestScoped
@Path("usuario")
public class UsuarioService {
    
      @EJB 
      UsuarioControllerLocal beanPrueba;
    
    @POST
    @Path("/registro")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregar(Usuario usuarios){
         
             beanPrueba.registrarUsuario(usuarios);
             System.out.println("Agregado");
            return Response.status(Response.Status.OK).entity(usuarios).build();
    }
    
   
   
    
}
