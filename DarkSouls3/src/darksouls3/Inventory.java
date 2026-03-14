/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.ArrayList;

/**
 *
 * @author lleshi.alessandro
 */
public class Inventory {
    protected int numberEstus;
    protected int numberAshenEstus;
    protected int greenBlossom;
    private ArrayList <Item> items = new ArrayList();

    public Inventory() {
        this.numberEstus = 5;
        this.numberAshenEstus = 5;
        this.greenBlossom = 5;
    }
    
    public void addItem(Item i){
        items.add(i);
    }
    public void removeitem(Item i){
        items.remove(i);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
}
