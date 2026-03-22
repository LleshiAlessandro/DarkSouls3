/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author aless
 */
public enum EnumItem {
    // EQUIPPABLE
    LONGSWORD(25, 0),
    GREATSWORD(30, 0),
    DAGGER(22, 0),
    GIANT_HAMMER(28, 0),

    // CONSUMABLE
    SIEGBRAU(0, 1),
    DIVINE_BLESSING(0, 1),
    EMBER(0, 1);

    private int baseDamage;   // solo per equipaggiabili
    private int quantity;     // solo per consumabili

    EnumItem(int baseDamage, int quantity) {
        this.baseDamage = baseDamage;
        this.quantity = quantity;
    }

    public int getBaseDamage() { return baseDamage; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
