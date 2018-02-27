/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.paintweb;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;

/**
 *
 * @author Cesar
 */
public class Cronometro implements Runnable {

    private Set<Jugador> LISTA_JUGADORES;

    public Cronometro(Set<Jugador> lista) {
        this.LISTA_JUGADORES = lista;
        System.out.println("Constructor RUNNABLE:" + lista);
    }

    static int SEGUNDOS = 0;
    static int turno = 0;

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Hilo runnable : " + SEGUNDOS);
                if (SEGUNDOS <= 0) {
                    Thread.currentThread().sleep(1000);
                    SEGUNDOS -= 1;
                    if (SEGUNDOS <= -10) {
                        SEGUNDOS = 1;
                        //Aumento el turno para el siguiente jugador
                        turno += 1;
                        int i = 0;
                        for (Jugador j : LISTA_JUGADORES) {

                            i += 1;
                            if (turno == i) {
                                j.setTurno(true);
                            } else {
                                j.setTurno(false);
                            }
                            //Envio a cada usuario si debe bloquear el blog de dibujo o no
                            try {
                                String turnoJson = "{\"accion\":\"bloquerBlog\",\"disabled\":\"" + j.getTurno() + "\"}";
                                j.getSession().getBasicRemote().sendObject(turnoJson);
                            } catch (IOException ex) {
                            } catch (EncodeException ex) {
                            }
                        }
                        //En caso de que el turno sea mayor a la lista vuelve y reinicia el turno
                        if (turno >= LISTA_JUGADORES.size()) {
                            turno = 0;
                        }
                    }
                } else {
                    for (Jugador j : LISTA_JUGADORES) {
                        String temporizador = "{\"accion\":\"cronometro\",\"time\":\"" + SEGUNDOS + "\"}";
                        try {
                            j.getSession().getBasicRemote().sendObject(temporizador);
                        } catch (IOException ex) {
                        } catch (EncodeException ex) {
                        }
                    }
                    Thread.currentThread().sleep(1000);
                    if (SEGUNDOS == 20) {
                        SEGUNDOS = -1;
                        System.out.println("Segundos´"+SEGUNDOS);
                    }
                    SEGUNDOS += 1;
                }
            }
        } catch (InterruptedException e) {
        }
    }

}
