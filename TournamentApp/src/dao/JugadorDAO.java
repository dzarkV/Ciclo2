/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Jugador;
import utils.ConnectionDB;

/**
 * Data Acces Object para la clase Jugador
 * @author dzark
 */
public class JugadorDAO {
    
    /**
     * Atributo para la conexión
     */
    private Connection conn = null;
    
    /**
     * Método para crear un jugador en BD
     * @param j Recibe un jugador
     */
    public void createJugador(Jugador j) {
        try
        {          
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql1 = "INSERT INTO Persona (identificacion, nombres, apellidos, fecha_nacimiento) VALUES(?,?,?,?)";
                String sql2 = "INSERT INTO Jugador (identificacion, posicion, codigo_equipo) VALUES(?,?,?)";
                
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                
                statement1.setInt(1, j.getId() );
                statement1.setString(2, j.getNombre());
                statement1.setString(3, j.getApellido());
                statement1.setDate(4, (Date) j.getFechaNacimiento());
                statement2.setInt(1, j.getId());
                statement2.setString(2, j.getPosicion());
                statement2.setInt(3, j.getCodEquipo());
                
                int rowsInserted = statement1.executeUpdate() + statement2.executeUpdate();
                
                if ( rowsInserted > 0 ) {
                    System.out.println("Inserción de Jugador exitosa!");
                }                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Método para consultar y mostrar en la tabla Read la lista de jugadores 
     * @param s
     * @return 
     */
    public List<Jugador> getJugadores(String s) {
        List<Jugador> jugadores = new ArrayList<>();
        
        try
        {          
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql = "SELECT Persona.identificacion, nombres, apellidos, fecha_nacimiento, posicion FROM Persona\n" +
                        " JOIN Jugador ON Persona.identificacion = Jugador.identificacion JOIN Equipo ON Jugador.codigo_equipo = Equipo.codigo\n" + 
                        " WHERE Equipo.nombre = ? ;";
                                
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, s);
                        
                ResultSet rs = statement.executeQuery();
                
                while(rs.next())
                {
                    Integer Id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellido = rs.getString(3);
                    Date fecha_nacimiento = rs.getDate(4);
                    String posicion = rs.getString(5);               
                    Jugador j = new Jugador(Id, nombre, apellido, fecha_nacimiento , posicion);   
                    jugadores.add(j);                    
                }
                                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
        
        return jugadores;
    }
    
    /**
     * Método para actualizar Jugador 
     * @param j Jugador seleccionado 
     */
    public void updateJugador(Jugador j){
        
        try
        {
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql1 = "UPDATE Jugador SET posicion=? WHERE identificacion=?";
                String sql2 = "UPDATE Persona SET nombres=?, apellidos=?, fecha_nacimiento=? WHERE identificacion=?";
                
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                
                statement2.setString(1, j.getNombre());
                statement2.setString(2, j.getApellido());
                statement2.setDate(3, (Date) j.getFechaNacimiento());
                statement2.setInt(4, j.getId());
                statement1.setString(1, j.getPosicion() );
                statement1.setInt(2, j.getId()); 
                
                int rowsInserted = statement1.executeUpdate() + statement2.executeUpdate() ;
                
                if ( rowsInserted > 0) {
                    System.out.println("Actualización de jugador exitosa!");
                }                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
