/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.Random;

/**
 *
 * @author aless
 */
public class EventManager {
    private Random rdn = new Random();
    private int randomEvent;

    public EventManager(Event e) {
        randomEvent = rdn.nextInt(0, 6);
        //da implementare tutti i metodi degli eventi
        //nel costruttore in base al numero del random richiamo un metodo di un evento
        //cosi quando costruisco l'evento ne prendo 1 a caso
    }
    
}
