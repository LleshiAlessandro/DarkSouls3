/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Knight extends Character{
    public Knight(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }
    
    @Override
    //il prescelto
    public void specialAbility(Villain v){
        //+50 vita
        if(getLife() >= 100){
            life = 150;
        }
        else{
            this.life = life + 50;
        }
        //+50 mana
        if(getMana() >= 50){
            mana = 100;
        }
        else{
            this.mana = mana + 50;
        }
        //+50 stamina
        if(getStamina() >= 50){
            stamina = 100;
        }
        else{
            this.stamina = stamina + 50;
        }
        
        //prendi 1 cura, 1 cura del mana e 1 della stamina
        inv.addNumberEstus();
        inv.addNumberAshenEstus();
        inv.addGreenBlossom();
    }
    @Override
    public String toString(){
        return "\"The Chosen One\"\n" +
                "\"A surge of destiny courses through the body of the chosen.\n" +
                "Life rekindles, wounds sealing as if the fire itself breathes anew.\n" +
                "Mana flows like sacred embers, rekindling the strength of the soul.\n" +
                "Stamina returns with relentless vigor, the body prepared for the trials that yet linger.\n" +
                "In this brief communion with fate, one finds an additional Estus, an Ashen Estus,\n" +
                "and a Green Blossom, as if providence itself deems you worthy to endure further still.\n" +
                "Yet beware—the boon is fleeting, and the road ahead is fraught with despair.\"\n\n" +
                "Effect:\n" +
                "  Restore 50 Life\n" +
                "  Restore 50 Mana (up to 100)\n" +
                "  Restore 50 Stamina (up to 100)\n" +
                "  Gain 1 Estus Flask\n" +
                "  Gain 1 Ashen Estus Flask\n" +
                "  Gain 1 Green Blossom";
    }
}
