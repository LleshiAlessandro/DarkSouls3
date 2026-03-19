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
        this.life = life + 50;

        //+50 mana
        this.mana = mana + 50;
        if(mana >= 100){mana = 100;}
        //+50 stamina
        this.stamina = stamina + 50;
        if(stamina >= 100){stamina = 100;}
        
        
        //prendi 1 cura, 1 cura del mana e 1 della stamina
        inv.numberEstus = inv.numberEstus + 1;
        inv.numberAshenEstus = inv.numberAshenEstus + 1;
        inv.greenBlossom = inv.greenBlossom + 1;
    }
    
}
