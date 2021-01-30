/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lscar
 */
public class Hospital {

    private int h_cod;
    private String h_nombre;
    private String h_direccion;
    private String h_telefono;
    private int h_numcama;

    public int getH_cod() {
        return h_cod;
    }

    public void setH_cod(int h_cod) {
        this.h_cod = h_cod;
    }

    public String getH_nombre() {
        return h_nombre;
    }

    public void setH_nombre(String h_nombre) {
        this.h_nombre = h_nombre;
    }

    public String getH_direccion() {
        return h_direccion;
    }

    public void setH_direccion(String h_direccion) {
        this.h_direccion = h_direccion;
    }

    public String getH_telefono() {
        return h_telefono;
    }

    public void setH_telefono(String h_telefono) {
        this.h_telefono = h_telefono;
    }

    public int getH_numcama() {
        return h_numcama;
    }

    public void setH_numcama(int h_numcama) {
        this.h_numcama = h_numcama;
    }
}
