/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EquipoDAO;
import java.util.ArrayList;
import model.Equipo;

/**
 *
 * @author dzark
 */
public class EquipoController {
    
    public void saveEquipo(Equipo e) {        
        EquipoDAO eq = new EquipoDAO();
        eq.createEquipo(e);        
    }
    
    public static ArrayList<String> updateCombo(){
        EquipoDAO eq = new EquipoDAO();
        return eq.updateCombbox();
    }
    
    public void DeleteWholeEquipo(String s){
        EquipoDAO eqq = new EquipoDAO();
        eqq.DeleteEquipo(s);
    }
}
