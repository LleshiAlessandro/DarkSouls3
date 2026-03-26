/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Priest extends Character {

    public Priest(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }

    @Override
    //benedizione degli angeli
    public void specialAbility(Villain v) {
        if (this.getMana() >= 25) {
            this.setLife(150);
            v.setLife(v.life = v.getLife() - 30);
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
                + "<h1> Blessing of the Angels</h1><br>"
                + "<p A divine radiance descends upon the Priest.<br>"
                + "Life is restored to its zenith, and the hand of heaven strikes the foe.<br>"
                + "Angelic power diminishes the enemy’s vitality by a sliver,<br>"
                + "turning prayer into righteous action.</p><br>"
                + "Effect:<br>"
                + "  Restore Life to 150<br>"
                + "  Deal 30 damage to enemy<br>"
                + "  it cost 25 mana<br>"
                + "</html>";
    }
}
