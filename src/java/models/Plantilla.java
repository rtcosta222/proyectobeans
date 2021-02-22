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
public class Plantilla {
    
    private int sala_cod;
    private int empleado_num;
    private String apellido;
    private String funcion;
    private String turno;
    private int salario;
    private int hospital_cod;

    public Plantilla () {        
    }
    
    public Plantilla (int sala_cod, 
                      int empleado_num, 
                      String apellido, 
                      String funcion,
                      String turno,
                      int salario,
                      int hospital_cod) {       
        this.sala_cod = sala_cod;
        this.empleado_num = empleado_num;
        this.apellido = apellido;
        this.funcion = funcion;
        this.turno = turno;
        this.salario = salario;
        this.hospital_cod = hospital_cod;
    }
    
    public int getHospital_cod() {
        return hospital_cod;
    }

    public void setHospital_cod(int hospital_cod) {
        this.hospital_cod = hospital_cod;
    }

    public int getSala_cod() {
        return sala_cod;
    }

    public void setSala_cod(int sala_cod) {
        this.sala_cod = sala_cod;
    }

    public int getEmpleado_num() {
        return empleado_num;
    }

    public void setEmpleado_num(int empleado_num) {
        this.empleado_num = empleado_num;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }    
}
