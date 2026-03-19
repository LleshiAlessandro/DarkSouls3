/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.Random;

/**
 *
 * @author lleshi.alessandro
 */
public class Item {
    private Random rdn = new Random();
    private EnumItem name;
    private int damage;
    private int quantity;

    // Costruttore che sceglie randomicamente un item
    public Item() {
        EnumItem[] Items = EnumItem.values();
        int index = rdn.nextInt(Items.length);
        this.name = Items[index];

        this.damage = name.getBaseDamage();
        this.quantity = name.getQuantity();
    }

    public EnumItem getName() { return name; }
    public int getDamage() { return damage; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        if(damage > 0) {
            return "Item: " + name + " (Damage: " + damage + ")" + "\n";
        } else {
            return "Item: " + name + " (Quantity: " + quantity + ")" + "\n";
        }
    }
    
}
