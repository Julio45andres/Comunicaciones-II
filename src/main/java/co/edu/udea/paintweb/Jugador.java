/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.paintweb;

import javax.websocket.Session;

/**
 * Tiene la informacion del jugador
 * @author Cesar
 */
public class Jugador {
    
    Session session;
    Boolean turno;
    String nombre;
    int puntos;
    
    public Jugador() {
    }
    
    public Jugador(Session session, Boolean turno, String nombre, int puntos) {
        this.session = session;
        this.turno = turno;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
  
}