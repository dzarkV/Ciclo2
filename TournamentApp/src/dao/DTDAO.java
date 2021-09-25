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

import model.DT;
import utils.ConnectionDB;

/**
 * Data Acces Object para la clase DT
 * @author dzark
 */
public class DTDAO {
    
    /**
     * Atributo para la conexión
     */
    private Connection conn = null;
    
    /**
     * Método para crear un DT en BD
     * @param dt Recibe un DT
     */
    public void createDT(DT dt) {
        try
        {          
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql1 = "INSERT INTO Persona (identificacion, nombres, apellidos, fecha_nacimiento) VALUES(?,?,?,?)";
                String sql2 = "INSERT INTO Director_Tecnico (identificacion, mesContrato, anioContrato) VALUES(?,?,?)";
                
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                
                statement1.setInt(1, dt.getId() );
                statement1.setString(2, dt.getNombre());
                statement1.setString(3, dt.getApellido());
                statement1.setDate(4, (Date) dt.getFechaNacimiento());
                statement2.setInt(1, dt.getId());
                statement2.setInt(2, dt.getMesContrato() );
                statement2.setInt(3, dt.getAnioContrato());
                
                int rowsInserted = statement1.executeUpdate() + statement2.executeUpdate();
                
                if ( rowsInserted > 0 ) {
                    System.out.println("Inserción de DT exitosa!");
                }                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Método para traer un DT según Equipo
     * @param s Selección en combobox de vista
     * @return 
     */
    public DT getDT(String s) {
        DT dirtec = null;
        
        try
        {          
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql = "SELECT Persona.identificacion, nombres, apellidos, fecha_nacimiento, mesContrato, anioContrato FROM Persona\n" +
                        "JOIN Director_Tecnico USING(identificacion)\n" +
                        "JOIN Equipo USING(identificacion)\n" + 
                        "WHERE Equipo.nombre = ? ;";
                                
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, s);
                        
                ResultSet rs = statement.executeQuery();
                
                if(rs.next())
                {
                    Integer Id = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellido = rs.getString(3);
                    Date fecha_nacimiento = rs.getDate(4);
                    Integer anioContrato = rs.getInt(6);   
                    Integer mesContrato = rs.getInt(5);
                    dirtec = new DT(Id, nombre, apellido, fecha_nacimiento , mesContrato, anioContrato);   
                    
                } else {
                    dirtec = new DT(null, null, null, null, null, null); 
                }
                                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
        
        return dirtec;
    }
    
    /**
     * Método para actualizar DT 
     * @param dt Director técnico seleccionado 
     */
    public void updateDT(DT dt){
        
        try
        {
            if(conn == null)
            {
                conn = ConnectionDB.getConnection();
                
                String sql1 = "UPDATE Director_Tecnico SET mesContrato=?, anioContrato=? WHERE identificacion=?";
                String sql2 = "UPDATE Persona SET nombres=?, apellidos=?, fecha_nacimiento=? WHERE identificacion=?";
                
                PreparedStatement statement1 = conn.prepareStatement(sql1);
                PreparedStatement statement2 = conn.prepareStatement(sql2);
                
                statement2.setString(1, dt.getNombre());
                statement2.setString(2, dt.getApellido());
                statement2.setDate(3, (Date) dt.getFechaNacimiento());
                statement2.setInt(4, dt.getId());
                statement1.setInt(1, dt.getMesContrato());
                statement1.setInt(2, dt.getAnioContrato());   
                statement1.setInt(3, dt.getId()); 
                
                int rowsInserted = statement1.executeUpdate() + statement2.executeUpdate() ;
                
                if ( rowsInserted > 0) {
                    System.out.println("Actualización de DT exitosa!");
                }                
                conn.close();                
            }
            
        } catch ( SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
