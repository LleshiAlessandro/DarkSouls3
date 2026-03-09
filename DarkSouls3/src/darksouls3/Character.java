/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public abstract class Character extends PgStatsCommon{
    
    private int mana;
    private int stamina;
    private Inventory inv = new Inventory(3, 3, 3);
    
    
    public Character(int mana, int stamina, String name, int life, int baseAtt) {
        super(name, life, baseAtt);
        this.mana = mana;
        this.stamina  = stamina;
    }
    
    //uso le cure
    public void useEstus(){
        inv.numberEstus--;
        if(inv.numberEstus > 0){
            if(getLife() >= 70){
                setLife(100);
            }
            else{
                setLife(life = life +30);
            }
        }
    }
    public void useAshenEstus(){
        inv.numberAshenEstus--;
        if(inv.numberAshenEstus > 0){
            if(mana >= 50){
                mana = 100;
            }
            else{
                mana += 50;
            }
        }
    }
    public void useGreenblossom(){
        inv.greenBlossom--;
        if(inv.greenBlossom > 0){
            if(stamina >= 50){
                stamina = 100;
            }
            else{
                stamina += 50;
            }
        }
    }
    
    //aggiunge 1 cura
    public void restoreHeals(){
        if(inv.numberEstus >= 5 && inv.numberAshenEstus >= 5 && inv.greenBlossom >= 5){
            
        }
        else{
        inv.numberEstus = inv.numberEstus + 1;
        inv.numberAshenEstus = inv.numberAshenEstus + 1;
        inv.greenBlossom = inv.greenBlossom + 1; 
        }
    }
    
    
    
    public abstract int specialAbility();
}
