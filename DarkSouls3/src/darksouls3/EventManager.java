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
    private Event lastEvent;

    public EventManager() {

    }
    
    public Event eventRandom(){
        randomEvent = rdn.nextInt(0, 5);
        switch (randomEvent) {
            case 0 -> {
                return lastEvent = Event.NEW_BOSS;
            }
            case 1 -> {
                return lastEvent = Event.ITEM_FOUND;
            }
            case 2 -> {
                return lastEvent = Event.NEW_LOCATION;
            }
            case 3 -> {
                return lastEvent = Event.NEW_NPC;
            }
            case 4 -> {
                return lastEvent = Event.RESTORE_HEALS;
            }
            default -> {
                return lastEvent = Event.NEW_LOCATION;
            }
        }
    }

    public Event getLastEvent() {
        return lastEvent;
    }
    
    
    
    @Override
    public String toString(){
        return "l'evento che è uscito è: " + getLastEvent() +"\n";
    }
}
