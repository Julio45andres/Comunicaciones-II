/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.paintweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author julio
 */
public class PalabrasAleatorias {
    
    final private List<String> palabras, palabrasPartida;
    final private Random gen;
    
    public PalabrasAleatorias() {
        palabras = new ArrayList<>();
        
        palabras.add("pintura");
        palabras.add("finca");
        palabras.add("oasis");
        palabras.add("koala");
        palabras.add("libertad");
        palabras.add("incognito");
        palabras.add("playa");
        palabras.add("ide");
        palabras.add("udea");
        palabras.add("aeropuerto");
        palabras.add("git");
        palabras.add("lluvia");
        palabras.add("musica");
        palabras.add("teatro");
        palabras.add("aventura");
        palabras.add("estatua");
        palabras.add("congreso");
        palabras.add("campaña");
        palabras.add("carcel");
        palabras.add("bosque");
        palabras.add("aguila");
        palabras.add("humor");
        palabras.add("linux");
        palabras.add("shell");
        palabras.add("campo");
        palabras.add("energia");
        palabras.add("televisor");
        palabras.add("pantalon");
        palabras.add("restaurante");
        palabras.add("websocket");
        palabras.add("consola");
        
        palabrasPartida = new ArrayList<>();
        palabrasPartida.addAll(palabras);
        
        //Esto evita que siempre genere la misma secuencia de números en cada ejecución.
        gen = new Random(System.currentTimeMillis());
    }
    

    /**
     * Este método retorna
     * @return Una palabra aleatoria
     */

    public String sacarPalabra(){
        //Escoge un indice entre 0 y el tamaño de la lista
        int indicePalabra = gen.nextInt(palabrasPartida.size());
        String palabra = palabrasPartida.get(indicePalabra);
        //Remueve la palabra escogida, para que no se vuelva a repetir.
        palabrasPartida.remove(indicePalabra);
        return palabra;
    }
}