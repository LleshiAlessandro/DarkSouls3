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

    public Inventory(int numberEstus, int numberAshenEstus, int greenBlossom) {
        this.numberEstus = numberEstus;
        this.numberAshenEstus = numberAshenEstus;
        this.greenBlossom = greenBlossom;
    }
    
    public void addItem(Item i){
        items.add(i);
    }
    public void removeitem(Item i){
        items.remove(i);
    }
}
