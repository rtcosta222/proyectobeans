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
public class DetallesHospital {
    // Atributos
    private int numpersonas;
    private int sumasal;
    private int mediasal;

    // Constructor
    public DetallesHospital() {
    }
    // Constructor
    public DetallesHospital(int numpersonas, int sumasal, int mediasal) {
        this.numpersonas = numpersonas;
        this.sumasal = sumasal;
        this.mediasal = mediasal;
    }

    // Methods
    public int getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(int numpersonas) {
        this.numpersonas = numpersonas;
    }

    public int getSumasal() {
        return sumasal;
    }

    public void setSumasal(int sumasal) {
        this.sumasal = sumasal;
    }

    public int getMediasal() {
        return mediasal;
    }

    public void setMediasal(int mediasal) {
        this.mediasal = mediasal;
    }
}
