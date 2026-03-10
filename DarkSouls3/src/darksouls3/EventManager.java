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
    

    public EventManager() {

    }
    
    public Event eventRandom(){
        randomEvent = rdn.nextInt(0, 5);
        switch (randomEvent) {
            case 0 -> {
                return Event.NEW_BOSS;
            }
            case 1 -> {
                return Event.ITEM_FOUND;
            }
            case 2 -> {
                return Event.NEW_LOCATION;
            }
            case 3 -> {
                return Event.NEW_NPC;
            }
            case 4 -> {
                return Event.RESTORE_HEALS;
            }
            default -> {
            }
        }
        return null;
    }
}
