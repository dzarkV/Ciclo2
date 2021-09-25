/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Equipo;
import utils.ConnectionDB;


/**
 * Data Acces Object para la clase Equipo
 * @author dzark
 */
public class EquipoDAO {
    
    /**
     * Atributo para la conexión
     */
    private Connection conn = null;
    
    /**
     * Método para crear un equipo en BD
     * @param e Recibe un equipo
     */
    public void createEquipo(Equipo e) {
        try
        {          
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql = "INSERT INTO Equipo (codigo, nombre, ciudad, nombre_estadio, anio_fundacion, identificacion) VALUES(?,?,?,?,?,?)";
                
                PreparedStatement statement = conn.prepareStatement(sql);
                
                statement.setInt(1, e.getCodigo());
                statement.setString(2, e.getNombre());
                statement.setString(3, e.getCiudad());
                statement.setString(4, e.getNombreEstadio() );
                statement.setString(5, e.getAnioFundacion());
                statement.setInt(6, e.getDTid());
                
                int rowsInserted = statement.executeUpdate();
                
                if ( rowsInserted > 0) {
                    System.out.println("Inserción de Equipo exitosa!");
                }                
            conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método para obtener los equipos de la BD en el combobox de ReadView 
     * @return  equipos como ArrayList para el combobox 
     * */
    public ArrayList<String> updateCombbox(){
        
       ArrayList<String> equipos = new ArrayList<>();
       try{
           if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql = "SELECT * FROM Equipo";
                PreparedStatement statement = conn.prepareStatement(sql);                
                
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    
                    equipos.add(rs.getString("nombre") );
                    
                };
                
            }    
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
       return equipos;
    }
    
    /**
     * Método para borrar un equipo, su DT y sus jugadores en BD
     * @param s Nombre del equipo seleccionado
     */
    public void DeleteEquipo(String s){
        try{
           if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql1 = "DELETE t1, t2 FROM Jugador AS t1 JOIN Persona AS t2 USING(identificacion)\n" +
                        " JOIN Equipo AS t3 ON t1.codigo_equipo = t3.codigo WHERE t3.nombre = ? ;";
                String sql2 = "DELETE t1, t2, t3 FROM Director_Tecnico AS t1 JOIN Persona AS t2 USING(identificacion)\n" +
                        " JOIN Equipo AS t3 ON t1.identificacion = t3.identificacion WHERE t3.nombre = ? ;";
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                statement1.setString(1, s);
                statement2.setString(1, s);
                
                int rowsInserted = statement1.executeUpdate() + statement2.executeUpdate() ;
                
                if ( rowsInserted > 0) {
                    System.out.println("Eliminación exitosa!");
                }
            }    
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
    }
}
