/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * * Clase para tabla Equipo
 * @author dzark
 */
public class Equipo {
    
    private Integer codigo;
    private String nombre;
    private String ciudad;
    private String nombreEstadio;
    private String anioFundacion;
    private Integer DTid;

    public Equipo(Integer codigo, String nombre, String ciudad, String nombreEstadio, String anioFundacion, Integer DTid) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.anioFundacion = anioFundacion;
        this.DTid = DTid;
    }

    public Integer getCodigo() {
        return codigo;
    }

//    public void setCodigo(Integer codigo) {
//        this.codigo = codigo;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(String anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public Integer getDTid() {
        return DTid;
    }

    public void setDTid(Integer DTid) {
        this.DTid = DTid;
    }
    
    
}
