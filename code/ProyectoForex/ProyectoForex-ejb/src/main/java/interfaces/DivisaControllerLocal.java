/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.Divisa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aleja
 */
@Local
public interface DivisaControllerLocal {
    
    public List<Divisa> traerDivisa1(String token);
    public List<Divisa> traerDivisa2(String token);
    public Integer cambiarDivisa1(String token);
    public Integer cambiarDivisa2(String token);
    
}
