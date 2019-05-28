/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Divisa;
import database.Usuario;
import database.consultas.ConsultasDivisa;
import database.consultas.ConsultasUsuario;
import interfaces.DivisaControllerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import seguridad.Seguridad;

/**
 *
 * @author aleja
 */
@Stateless
public class DivisaController implements DivisaControllerLocal {

    @Override
    public List<Divisa> traerDivisa1(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasDivisa consulta = new ConsultasDivisa();
       List<Divisa> listaDivisa = new ArrayList();
       listaDivisa= consulta.traerNombreDivisa1(token);     
        return listaDivisa;
        }
    
    @Override
    public List<Divisa> traerDivisa2(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasDivisa consulta = new ConsultasDivisa();
       List<Divisa> listaDivisa = new ArrayList();
       listaDivisa= consulta.traerNombreDivisa2(token);     
        return listaDivisa;
    }
    
    @Override
    public Integer cambiarDivisa1(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasDivisa consulta = new ConsultasDivisa();
       List<Divisa> listaDivisa = new ArrayList();
       listaDivisa= consulta.traerNombreDivisa1(token);
        for (Usuario usuarios : listaUsuario) {
            if(usuarios.getCorreo().equals(correoUsua)){
               for (Divisa divisas : listaDivisa) {
                    int valorEntero =(int) Math.floor(Math.random()*(-5-5+1)+5);
                    int valorF = divisas.getValorandom()+valorEntero;
                    System.out.println("ValorF "+valorF);
                    ConsultasDivisa consultaD= new ConsultasDivisa();
                    consultaD.editarValorDivisa1(valorF);

                    return 1;
                }     
            }
        }  
         return null;
    }

    @Override
    public Integer cambiarDivisa2(String token) {
       String correoUsua= Seguridad.desencriptar(token);
       ConsultasUsuario consultaU = new ConsultasUsuario();
       List<Usuario> listaUsuario = new ArrayList();
       listaUsuario=consultaU.usuarioToken(token);
       ConsultasDivisa consulta = new ConsultasDivisa();
       List<Divisa> listaDivisa = new ArrayList();
       listaDivisa= consulta.traerNombreDivisa2(token);
        for (Usuario usuarios : listaUsuario) {
            if(usuarios.getCorreo().equals(correoUsua)){
               for (Divisa divisas : listaDivisa) {
                    int valorEntero =(int) Math.floor(Math.random()*(-5-5+1)+5);
                    int valorF = divisas.getValorandom()+valorEntero;
                    System.out.println("ValorF "+valorF);
                    ConsultasDivisa consultaD= new ConsultasDivisa();
                    consultaD.editarValorDivisa2(valorF);

                    return 1;
                }     
            }
        }  
         return null;
    }

    
       
}
        

