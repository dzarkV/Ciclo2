/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * * Clase para tabla Director_Tecnico
 * @author dzark
 */
public class DT extends Persona {
    
    private Integer mesContrato;
    private Integer anioContrato;
    
    
    public DT(Integer id, String nombre, String apellido, Date fechaNacimiento, Integer mesContrato, 
            Integer anioContrato) {
        super(id, nombre, apellido, fechaNacimiento);
        this.mesContrato = mesContrato;
        this.anioContrato = anioContrato;
    }
    

    public Integer getMesContrato() {
        return mesContrato;
    }

    public void setMesContrato(Integer mesContrato) {
        this.mesContrato = mesContrato;
    }

    public Integer getAnioContrato() {
        return anioContrato;
    }

    public void setAnioContrato(Integer anioContrato) {
        this.anioContrato = anioContrato;
    }
    
    
}
