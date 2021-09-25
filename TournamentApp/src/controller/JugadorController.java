/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JugadorDAO;
import java.util.List;
import model.Jugador;

/**
 *
 * @author dzark
 */
public class JugadorController {
    
    public void saveJugador(Jugador j) {        
        JugadorDAO jd = new JugadorDAO();
        jd.createJugador(j);        
    }
    
    public List<Jugador> readJugadores(String s){
        JugadorDAO jd = new JugadorDAO();
        return jd.getJugadores(s);
    }
    
    public void updateJugadorC(Jugador j) {
        JugadorDAO jd = new JugadorDAO();
        jd.updateJugador(j);
    }
}
