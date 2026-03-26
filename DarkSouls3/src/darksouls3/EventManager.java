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

    public Event eventRandom() {
        randomEvent = rdn.nextInt(0, 101);
        if (randomEvent <= 30) {
            return lastEvent = Event.NEW_BOSS;
        } else if (randomEvent >= 31 && randomEvent <= 45) {
            return lastEvent = Event.RESTORE_HEALS;
        } else if (randomEvent >= 46 && randomEvent <= 70) {
            return lastEvent = Event.NEW_LOCATION;
        } else if (randomEvent >= 71 && randomEvent <= 85) {
            return lastEvent = Event.NEW_NPC;
        } else if (randomEvent >= 86 && randomEvent <= 100) {
            return lastEvent = Event.ITEM_FOUND;
        }
        return lastEvent = Event.NEW_LOCATION;
    }

    public Event getLastEvent() {
        return lastEvent;
    }

    @Override
    public String toString() {
        return "l'evento che è uscito è: " + getLastEvent() + "\n";
    }
}
