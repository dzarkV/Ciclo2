/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DTDAO;
import java.util.List;
import model.DT;

/**
 *
 * @author dzark
 */
public class DTController {
    
    public void saveDT(DT dt) {        
        DTDAO Ddt = new DTDAO();
        Ddt.createDT(dt);        
    }
    
    public DT readDT(String s){
        DTDAO dt = new DTDAO();
        return dt.getDT(s) ;
    }
    
    public void updateDTC(DT dt){
        DTDAO dtd = new DTDAO();
        dtd.updateDT(dt);
    }
}
