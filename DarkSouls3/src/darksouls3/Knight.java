/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Knight extends Character {

    public Knight(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }

    @Override
    //il prescelto
    public void specialAbility(Villain v) {
        //+50 vita
        if (this.getMana() >= 50) {
            if (getLife() >= 100) {
                this.setLife(150);
            } else {
                this.setLife(this.getLife() + 50);
            }

            //+50 stamina
            if (getStamina() >= 50) {
                this.setStamina(100);
            } else {
                this.setStamina(this.getStamina() + 50);
            }
            inv.addNumberEstus();
            inv.addNumberAshenEstus();
            inv.addGreenBlossom();
        } else {
            if (this.inv.getNumberAshenEstus() > 0) {
                this.useAshenEstus();
            } else {

            }
        }
        this.setMana(this.getMana() - 50);
    }

    @Override
    public String toString() {
        return "<html>"
                + "<h1> The Chosen One </h1> <br>"
                + "<p A surge of destiny courses through the body of the chosen.<br>"
                + "Life rekindles, wounds sealing as if the fire itself breathes anew.<br>"
                + "Mana flows like sacred embers, rekindling the strength of the soul.<br>"
                + "Stamina returns with relentless vigor, the body prepared for the trials that yet linger.<br>"
                + "In this brief communion with fate, one finds an additional Estus, an Ashen Estus,<br>"
                + "and a Green Blossom, as if providence itself deems you worthy to endure further still.<br>"
                + "Yet beware—the boon is fleeting, and the road ahead is fraught with despair.</p><br>"
                + "Effect:<br>"
                + "  Restore 50 Life<br>"
                + "  Restore 50 Mana (up to 100)<br>"
                + "  Restore 50 Stamina (up to 100)<br>"
                + "  Gain 1 Estus Flask<br>"
                + "  Gain 1 Ashen Estus Flask<br>"
                + "  Gain 1 Green Blossom<br>"
                + "  It cost 50 mana"
                + "</html>";
    }
}
