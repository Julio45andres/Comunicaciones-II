/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.paintweb;

import co.edu.udea.dto.Pojo;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Esta clase es la encargada de recibir la informacion de los usuarios y replicarla a los demass
 * @author Cesar
 */

@ServerEndpoint(value="/paintweb",encoders = {DatosEncoder.class},decoders = {DatosDecoder.class})
public class PaintWebServer {
    
    /**
     * Lista de usuarios conectados
     */
    private static final Set<Session> CLIENTES=Collections.synchronizedSet(new HashSet<Session>());
    private static final List<Jugador> LISTA_JUGADORES=new ArrayList<Jugador>();
    
    /**
     * Este metodo se encarga de recibir los datos y enviarselo a los demas usuarios conectados
     * @param datos recibidos por el ususarios
     * @param session del usuario que envia los datos
     * @throws IOException 
     * @throws EncodeException 
     */
    @OnMessage
    public void broadcastFigure(Datos datos,Session session) throws IOException, EncodeException {
        System.out.println("Datos: "+datos);
        
        //Se condiciona por la accion a ejecutar
        if(datos.getJson().getString("accion").equals("newUser")){
            agregarNombreJugador(session,datos.getJson().getString("name"));            
            this.listarUsuarios();
        }
        else{
            System.out.println("NO ENTRO");
            for(Session usuarios: CLIENTES){
                if(!usuarios.equals(session)){
                    usuarios.getBasicRemote().sendObject(datos);
                }
            }
        }
        
    }
    
    /**
     * Esta funcion agrega en nuevo usuario a la lista de usuarios conectados
     * @param cliente session del cliente que abre la conexion
     */
    @OnOpen
    public void onOpen(Session cliente) {
        CLIENTES.add(cliente);
        
        //Agrega un nuevo jugador a la lista y le seteo la session por el momento
        Jugador j=new Jugador();
        j.setSession(cliente);
        LISTA_JUGADORES.add(j);
    }

    @OnError
    public void onError(Throwable t) {
    }

    /**
     * Metodo encargado de eliminar el cliente de la lista de usuarios conectados
     * @param cliente session del cliente que cierra la conexion
     */
    @OnClose
    public void onClose(Session cliente) throws IOException, EncodeException {
        CLIENTES.remove(cliente);
        for(Jugador j: LISTA_JUGADORES){
            if(j.getSession().equals(cliente)){
                LISTA_JUGADORES.remove(j);
                this.listarUsuarios();
                break;
            }
        }
    }
    
    public void agregarNombreJugador(Session s,String nombre){
        for(Jugador j: LISTA_JUGADORES){
            if(j.getSession().equals(s)){
                j.setNombre(nombre);
                break;
            }
        }
    }
    
    public void listarUsuarios() throws IOException, EncodeException{
        String jsonUsuarios="{\"accion\":\"newUser\",\"listaUsers\":[";
        for(Jugador j: LISTA_JUGADORES){
            jsonUsuarios +="\""+j.getNombre()+"\",";
        }
        jsonUsuarios =jsonUsuarios.substring(0, jsonUsuarios.length()-1);
        jsonUsuarios +="]}";

        for(Session usuarios: CLIENTES){                
            usuarios.getBasicRemote().sendObject(jsonUsuarios);                
        }
    }
}
