/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Divisa;
import database.Operacion;
import database.Usuario;
import database.consultas.ConsultasDivisa;
import database.consultas.ConsultasOperacion;
import database.consultas.ConsultasUsuario;
import interfaces.OperacionControllerLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import seguridad.Seguridad;

/**
 *
 * @author aleja
 */
@Stateless
public class OperacionController implements OperacionControllerLocal {

    @Override
    public String registrarOperacion(Operacion operacion) {
        try {
             ConsultasOperacion registro =new ConsultasOperacion();
             registro.registrarOperacion(operacion);
             return "";
        } catch (Exception ex) {
            System.out.println("SALIO ALGO MAL"+ex.getMessage());
        }
        return "falló";
    }

    @Override
    public List<Operacion> traerOperaciones(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);     
        return listaOperacion;
    }

    
    @Override
    public boolean cerrarOperacion(Integer idoperacion, String token) {
       Usuario usuario = new Usuario();
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consulta = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario= consulta.usuarioToken(token);
       for (Usuario usuarios : listaUsuario) {
            if(usuarios.getToken().equals(token)){  
                try {
                    ConsultasOperacion cambiarValidar = new ConsultasOperacion();
                    cambiarValidar.editarValidar(idoperacion);
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
       }
     return false;
    }

    @Override
    public List<Operacion> traerHistorial(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerHistorial(token);     
        return listaOperacion;
    }
 
    @Override
    public Integer cambiarValorActual(String token) {
       ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);
                for(Operacion operaciones: listaOperacion){
                    if(operaciones.getDivisa().contains("AUD/USD")){
                        int valorEntero =(int) Math.floor(Math.random()*(-10-10+1)+10);
                        int valorF = operaciones.getNumactual()+valorEntero;
                        ConsultasOperacion consultaD= new ConsultasOperacion();
                        consultaD.editarValorActual1(valorF);
                    }else if(operaciones.getDivisa().contains("USD/JPY")){
                        int valorEntero =(int) Math.floor(Math.random()*(-10-10+1)+10);
                        int valorF = operaciones.getNumactual()+valorEntero;
                        ConsultasOperacion consultaD= new ConsultasOperacion();
                        consultaD.editarValorActual2(valorF);
                    }
                    return 1;    
                }
       return 0;   
    }


    @Override
    public Integer cambiarSaldo(String token) {
        ConsultasOperacion consulta = new ConsultasOperacion();
       List<Operacion> listaOperacion = new ArrayList();
       listaOperacion= consulta.traerOperaciones(token);
                for(Operacion operaciones: listaOperacion){
                    if(operaciones.getDivisa().equals("AUD/USD") && operaciones.getOperacion().equals("compra")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumactual()-operaciones.getNumelegido());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual1(saldoOp);
                           
                    }else if(operaciones.getDivisa().equals("AUD/USD") && operaciones.getOperacion().equals("vender")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumelegido()-operaciones.getNumactual());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual1(saldoOp);
                           
                      }else if(operaciones.getDivisa().equals("USD/JPY") && operaciones.getOperacion().equals("compra")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumactual()-operaciones.getNumelegido());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual2(saldoOp);
                          
                        }else if(operaciones.getDivisa().equals("USD/JPY") && operaciones.getOperacion().equals("vender")){
                            ConsultasOperacion consultaD= new ConsultasOperacion();
                            int lote =operaciones.getLote();
                            int diferencia = (operaciones.getNumelegido()-operaciones.getNumactual());
                            int saldoOp = lote * diferencia;   
                            consultaD.editarSaldoActual2(saldoOp);
                           
                        }
                    return 1;  
                    }
                     
                     return 0;   
                }
      
    }
