/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;




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
    
//      @EJB 
//      PruebaLocal beanPrueba;
//    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ver")
    public Response verUsuarios(){
//             int suma = beanPrueba.sumar(2, 3);
//             System.out.println(suma);
        
//             beanPrueba.guardar();
//             System.out.println("Agregado");
             
//             beanPrueba.editar();
//             System.out.println("Editado");
//             
//             beanPrueba.editarEspecifico();
//             System.out.println("Editado");
//             
//             beanPrueba.eliminar();
//             System.out.println("Eliminar");
             
//             beanPrueba.buscar();
//             System.out.println(".");
            return Response.status(Response.Status.OK).build();
    }
    
    
   
    
}
