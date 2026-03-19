/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class ItemEquippable extends Item{
    private int damage;

    public ItemEquippable(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
