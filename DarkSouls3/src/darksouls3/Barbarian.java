/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Barbarian extends Character {

    public Barbarian(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }

    @Override
    //modalità berserk
    public void specialAbility(Villain v) {

        if (this.getLife() <= 10 && this.getMana() >= 20) {
            v.setLife(0);
        } else {
            if (this.inv.getNumberAshenEstus() > 0) {
                this.useAshenEstus();
            } else {

            }
        }
        this.setMana(this.getMana() - 20);
    }

    @Override
    public String toString() {
        return "<html>"
                + "<h1> Berserk Mode</h1><br>"
                + "<p When the Barbarian stands at death's door, fury consumes all reason.<br>"
                + "With but a breath of life remaining, the foe is struck down utterly,<br>"
                + "as if destiny itself wills their annihilation. The body fights for survival,<br>"
                + "and the enemy falls before the wrath of the chosen warrior. </p><br>"
                + "Effect:<br>"
                + "  If life <= 10, enemy instantly reduced to 0 Life<br>"
                + "  It cost 20 mana<br>"
                + "</html>";

    }
}
