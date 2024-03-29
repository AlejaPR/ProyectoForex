package database.consultas;
import database.Divisa;
import database.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alejandra Pabon Rodriguez
 * 461 215 234 
 * Clase consultas divisa contiene todas las consultas de base de datos a la tabla divisa
 */
public class ConsultasDivisa {
    
    private Conexion re;
            
    public ConsultasDivisa() {
        
        re=new Conexion();
    }
    
    List<Divisa> listaDivisa = new ArrayList<>();
    
    /**consulta para traer la divisa 1**/
    public List<Divisa> traerNombreDivisa1(String token){
        Divisa divisas = new Divisa();
        try {
             Statement stmt = re.con.createStatement();
             String sql = "SELECT * FROM divisa where idivisa=1";
             ResultSet rs = stmt.executeQuery(sql);
             while(rs.next()){
                    divisas.setNombredivisa(rs.getString("nombredivisa"));
                    divisas.setValorandom(rs.getInt("valorandom"));
                    divisas.setValorbase(rs.getInt("valorbase"));
                    listaDivisa.add(divisas);
             }   
                rs.close();
                stmt.close();
                re.cerrarConexion();
                return listaDivisa;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return listaDivisa;
    }
    /**consulta que trae la divisa 2**/
    public List<Divisa> traerNombreDivisa2(String token){
        Divisa divisas = new Divisa();
        try {
             Statement stmtt = re.con.createStatement();
             String sql = "SELECT * FROM divisa where idivisa=2";
             ResultSet rst = stmtt.executeQuery(sql);
             while(rst.next()){
                    divisas.setNombredivisa(rst.getString("nombredivisa"));
                    divisas.setValorandom(rst.getInt("valorandom"));
                    divisas.setValorbase(rst.getInt("valorbase"));
                    listaDivisa.add(divisas);
             }   
                rst.close();
                stmtt.close();
                re.cerrarConexion();
                return listaDivisa;
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
        return listaDivisa;
    }
    
    /**consulta que cambia el valor de la divisa uno**/
    public void editarValorDivisa1(Integer valorF){
        Divisa divisas = new Divisa();
        try {
             Statement stmtR1 = re.con.createStatement();
             String sql = "UPDATE divisa SET valorandom="+"'"+valorF+"'"+" WHERE valorbase=1934";
             int rstR1 = stmtR1.executeUpdate(sql);
                stmtR1.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
    
    /**consulta que cambia el valor de la divisa dos**/
    public void editarValorDivisa2(Integer valorF){
        Divisa divisas = new Divisa();
        try {
             Statement stmtR2 = re.con.createStatement();
             String sql = "UPDATE divisa SET valorandom="+"'"+valorF+"'"+" WHERE valorbase=2130";
             int rstR2 = stmtR2.executeUpdate(sql);
                stmtR2.close();
                re.cerrarConexion();
               
        }catch(SQLException ex) {
             System.out.println("fallo traerinfo");
         } catch (Exception ex) {
             System.out.println("fallo traerinfo");
        }
       
    }
}
