/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Priest extends Character{
    
    public Priest(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }
    
    @Override
    //benedizione degli angeli
    public void specialAbility(Villain v){
        life = 100;
        v.setLife(v.life = v.getLife() -30);
    }
    @Override
    public String toString(){
        return "\"Blessing of the Angels\"\n" +
    "\"A divine radiance descends upon the Priest.\n" +
    "Life is restored to its zenith, and the hand of heaven strikes the foe.\n" +
    "Angelic power diminishes the enemy’s vitality by a sliver,\n" +
    "turning prayer into righteous action.\"\n\n" +
    "Effect:\n" +
    "  Restore Life to 100\n" +
    "  Deal 30 damage to enemy";
    }
}
