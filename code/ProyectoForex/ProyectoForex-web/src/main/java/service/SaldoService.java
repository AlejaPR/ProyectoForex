/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Mensaje;
import database.Saldo;
import database.Usuario;
import interfaces.SaldoControllerLocal;
import interfaces.UsuarioControllerLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author aleja
 */
@javax.enterprise.context.RequestScoped
@Path("saldo")
public class SaldoService {
    
    @EJB 
    UsuarioControllerLocal beanSaldo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{token}/{saldo}")
    public Response modificarSaldo(@PathParam("token") String token, @PathParam("saldo") Integer saldo){
        try{
            System.out.println("saldo"+saldo);
            Usuario u = new Usuario();
            u.setSaldo(beanSaldo.modificarSaldo(token, saldo));
            if(u.getSaldo().equals(1)){
                return Response.status(Response.Status.OK).entity(u).build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity(u).build();
            }
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }

    @EJB 
    SaldoControllerLocal beanSaldoI;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saldoH/{token}")
    public Response traerSaldoH(@PathParam("token") String token){
        try{

            List<Saldo> saldo=new ArrayList();
            saldo = beanSaldoI.traerSaldoHistorial(token);
                return Response.status(Response.Status.OK).entity(saldo).build(); 
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/editarSaldo/{token}")
    public Response traerSaldoI(@PathParam("token") String token, Saldo saldo){
        try{
            System.out.println("Saldo imaginario"+saldo.getSaldoimaginario());
              List<Saldo> saldoI=new ArrayList();
              saldoI=  beanSaldoI.traerSaldo(token,saldo);
                return Response.status(Response.Status.OK).entity(saldoI).build(); 
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
           
        }  
    }
    
   

}
    
