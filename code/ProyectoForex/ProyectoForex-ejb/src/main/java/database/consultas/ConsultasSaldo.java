package database.consultas;
import database.Saldo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase que trae las consultas de saldo 
 */
public class ConsultasSaldo {
    
     private Conexion re;
            
    public ConsultasSaldo() {
        
        re=new Conexion();
    }
    
    List<Saldo> listaSaldo = new ArrayList<>();
    
    /**consulta que trae el saldo actual del usuario**/
    public List<Saldo> traerSaldo(String token){
        try {
             Statement stmtt = re.con.createStatement();
             String sql = "SELECT * FROM saldo";
             ResultSet rst = stmtt.executeQuery(sql);
             while(rst.next()){
                   Saldo saldo= new Saldo();
                   saldo.setIdsaldo(rst.getInt("idsaldo"));
                   saldo.setSaldoimaginario(rst.getInt("saldoimaginario"));
                   saldo.setGanancias(rst.getInt("ganancias"));
                   saldo.setPerdidas(rst.getInt("perdidas"));

                    listaSaldo.add(saldo);
             }   
                rst.close();
                stmtt.close();
                re.cerrarConexion();
                return listaSaldo;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return null;
    }
    
    /**consulta que edita el saldo imaginario**/
    public void editarSaldo(Integer saldo){
        
        try {
            Statement stmtSS = re.con.createStatement();
            String sql= "UPDATE saldo SET saldoimaginario="+"'"+saldo+"'"+"";
            System.out.println(sql);
            int rse = stmtSS.executeUpdate(sql);
            System.out.println("Cambio correcto");
            stmtSS.close();
            re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo cambio saldo"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Saldo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**consulta que edita las ganancias**/
    public void editarGanancias(Integer ganancias){
        try {
            Statement stmtg = re.con.createStatement();
            String sql= "UPDATE saldo SET ganancias="+"'"+ganancias+"'"+"";
            System.out.println(sql);
            int rsg = stmtg.executeUpdate(sql);
            System.out.println("Cambio correcto");
            stmtg.close();
            re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo cambio saldo"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Saldo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**consulta que edita las perdidas**/
     public void editarPerdidas(Integer perdidas){
        try {
            Statement stmtp = re.con.createStatement();
            String sql= "UPDATE saldo SET perdidas="+"'"+perdidas+"'"+"";
            System.out.println(sql);
            int rsp = stmtp.executeUpdate(sql);
            System.out.println("Cambio correcto");
            stmtp.close();
            re.cerrarConexion();
        } catch (SQLException ex) {
               System.out.println("fallo cambio saldo"+ex);

        } catch (Exception ex) {
            Logger.getLogger(Saldo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
