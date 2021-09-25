/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * Clase para tabla Jugador
 * @author dzark
 */
public class Jugador extends Persona  {
    
    private String posicion;
    private Integer codEquipo;
    
    public Jugador(Integer id, String nombre, String apellido, Date fechaNacimiento, String posicion, Integer codEquipo) {
        super(id, nombre, apellido, fechaNacimiento);
        this.posicion = posicion;
        this.codEquipo = codEquipo;
    }
    /**
     * Sobrecarga de constructor para obtener la tabla de la lista con las columnas escogidas en el query de JugadorDAO
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param posicion    
     * Sin código de equipo
     */
    public Jugador(Integer id, String nombre, String apellido, Date fechaNacimiento, String posicion) {
        super(id, nombre, apellido, fechaNacimiento);
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }
    
    
}
