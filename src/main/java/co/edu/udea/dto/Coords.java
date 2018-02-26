/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.dto;

import java.io.Serializable;

/**
 *
 * @author Cesar
 */
public class Coords implements Serializable{

    private int x,y;
    
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
