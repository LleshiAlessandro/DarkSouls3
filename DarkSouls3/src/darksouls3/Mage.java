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
public class Mage extends Character{
    
    public Mage(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }
    
    @Override
    //lascia o raddoppia
    public void specialAbility(Villain v){
        Random rdn = new Random();
        int i = rdn.nextInt(0, 2);
        if(this.getMana() >= 25){
            if(i == 0){
                mana = 100;
                if(getStamina() >=70){
                    stamina = 100;
                }
                else{
                    stamina = stamina +30;
                }
            }
            else{
                if(v.getLife() >= 70){
                    v.setLife(100);
                }
                else{
                    v.setLife(v.life = v.getLife() + 30);
                }
            }
        }
        else{
           if(this.inv.getNumberAshenEstus() > 0){
               this.useAshenEstus();
           }
           else{

           }
        }
        
        this.setMana(this.getMana() - 25);
    }
    @Override
    public String toString(){
        //da sistemare visivamente
    return  "<html>" +
    "<h3 Gamble of Fate /h3> </html> \n" +
    "\"The Mage toys with the threads of chance and destiny.\n" +
    "One moment, mana and stamina are replenished, invigorating the body and soul.\n" +
    "The next, the enemy’s vitality may surge or wane, subject to the whims of fortune.\n" +
    "No outcome is certain; only the brave manipulate fate itself.\"\n\n" +
    "Effect:\n" +
    "  Randomly:\n" +
    "    - Restore mana to 100 and stamina (+30 or 100 if >=70)\n" +
    "    - Enemy gains 30 Life (or 100 if enemy life >=70)\n" +
    "    - It cost 25 mana ";
    
    }
}
