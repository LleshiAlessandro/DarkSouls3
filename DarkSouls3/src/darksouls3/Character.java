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
    
    protected int mana;
    protected int stamina;
    protected Inventory inv = new Inventory();
    
    
    public Character(int mana, int stamina, String name, int life, int baseAtt) {
        super(name, life, baseAtt);
        this.mana = mana;
        this.stamina  = stamina;
    }
    
    //uso le cure
    public void useEstus(){
        if(inv.numberEstus > 0){
            inv.numberEstus--;
            if(getLife() >= 120){
                setLife(150);
            }
            else{
                setLife(life = life +30);
            }
        }
    }
    public void useAshenEstus(){
        
        if(inv.numberAshenEstus > 0){
            inv.numberAshenEstus--;
            if(mana >= 50){
                mana = 100;
            }
            else{
                mana += 50;
            }
        }
    }
    public void useGreenblossom(){
        if(inv.greenBlossom > 0){
            inv.greenBlossom--;
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
    
    //use,add,remove Item da implementare

    public int getMana() {
        return mana;
    }

    public int getStamina() {
        return stamina;
    }
    
    
    public abstract void specialAbility(Villain v);
}
