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
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase bean controler de divisa
 */
@Stateless
public class DivisaController implements DivisaControllerLocal {

    /**Metodo que trae la divisa uno a home**/
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
    /**Metodo que trae la divisa dos a home**/
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
    
    /**Metodo que cambiar el random de la divisa uno**/
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

    /**Metodo que cambia el random de la divisa dos**/
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
        

