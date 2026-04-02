/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.Serializable;

/**
 *
 * @author aless
 */
public class Player implements Serializable{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
