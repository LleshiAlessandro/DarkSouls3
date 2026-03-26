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
public class Mage extends Character {

    public Mage(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }

    @Override
    //lascia o raddoppia
    public void specialAbility(Villain v) {
        Random rdn = new Random();
        int i = rdn.nextInt(0, 2);
        if (this.getMana() >= 25) {
            if (i == 0) {
                mana = 100;
                if (getStamina() >= 70) {
                    stamina = 100;
                } else {
                    stamina = stamina + 30;
                }
            } else {
                if (v.getLife() >= 70) {
                    v.setLife(100);
                } else {
                    v.setLife(v.life = v.getLife() + 30);
                }
            }
        } else {
            if (this.inv.getNumberAshenEstus() > 0) {
                this.useAshenEstus();
            } else {

            }
        }

        this.setMana(this.getMana() - 25);
    }

    @Override
    public String toString() {
        return "<html>"
                + "<h1>Gamble of Fate</h1>"
                + "<p>The Mage toys with the threads of chance and destiny.<br>"
                + "One moment, mana and stamina are replenished, invigorating the body and soul.<br>"
                + "The next, the enemy’s vitality may surge or wane, subject to the whims of fortune.<br>"
                + "No outcome is certain; only the brave manipulate fate itself.</p>"
                + "<p><b>Effect:</b><br>"
                + "Randomly:<br>"
                + "- Restore mana to 100 and stamina (+30 or 100 if &ge; 70)<br>"
                + "- Enemy gains 30 Life (or 100 if enemy life &ge; 70)<br>"
                + "<b>Cost:</b> 25 mana</p>"
                + "</html>";

    }
}
