/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author lleshi.alessandro
 */
public class Inventory implements Serializable{

    protected int numberEstus;
    protected int numberAshenEstus;
    protected int greenBlossom;
    protected ArrayList<Item> items = new ArrayList();

    public Inventory() {
        this.numberEstus = 5;
        this.numberAshenEstus = 5;
        this.greenBlossom = 5;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void removeitem(Item i) {
        items.remove(i);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getNumberEstus() {
        return numberEstus;
    }

    public int getNumberAshenEstus() {
        return numberAshenEstus;
    }

    public int getGreenBlossom() {
        return greenBlossom;
    }

    public void addNumberEstus() {
        this.numberEstus = numberEstus + 1;
    }

    public void addNumberAshenEstus() {
        this.numberAshenEstus = numberAshenEstus + 1;
    }

    public void addGreenBlossom() {
        this.greenBlossom = greenBlossom + 1;
    }

    @Override
    public String toString() {
        return "items: " + getItems();
    }
}
