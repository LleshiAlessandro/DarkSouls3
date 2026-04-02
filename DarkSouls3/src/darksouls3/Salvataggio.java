/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.Serializable;


/**
 *
 * @author lleshi.alessandro
 */
public class Salvataggio implements Serializable{

    //dovrò inserire tutti i dati che dorvò salvare, così che con la serializzazione inserirò 1 solo oggetto Salvataggio nel fileManager e salverò tutto
    //con 1 solo oggetto
    private Character c;
    private Player p;

    public Salvataggio(Character c, Player p) {
        this.c = c;
        this.p = p;
    }
    //i get mi servono per leggere i file nell ObjectInputStream
    public Character getC() {
        return c;
    }

    public Player getP() {
        return p;
    }
    
}
