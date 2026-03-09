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

        if(i == 1){
            mana = 100;
            if(stamina >=70){
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
                v.setLife(v.life = v.life + 30);
            }
        }
    }
}
