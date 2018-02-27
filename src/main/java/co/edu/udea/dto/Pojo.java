package co.edu.udea.dto;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cesar
 */
public class Pojo implements Serializable{

    private String accion,color,tam,name,msj;
    private Coords coords;
    private boolean iniDibujarOtroCliente,finDibujarOtroCliente;
    
    public Pojo() {
    }

    public Pojo(String accion, String color, String tam, String name, String msj, Coords coords, boolean iniDibujarOtroCliente, boolean finDibujarOtroCliente) {
        this.accion = accion;
        this.color = color;
        this.tam = tam;
        this.name = name;
        this.msj = msj;
        this.coords = coords;
        this.iniDibujarOtroCliente = iniDibujarOtroCliente;
        this.finDibujarOtroCliente = finDibujarOtroCliente;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public boolean isIniDibujarOtroCliente() {
        return iniDibujarOtroCliente;
    }

    public void setIniDibujarOtroCliente(boolean iniDibujarOtroCliente) {
        this.iniDibujarOtroCliente = iniDibujarOtroCliente;
    }

    public boolean isFinDibujarOtroCliente() {
        return finDibujarOtroCliente;
    }

    public void setFinDibujarOtroCliente(boolean finDibujarOtroCliente) {
        this.finDibujarOtroCliente = finDibujarOtroCliente;
    }
    
    
    
}
