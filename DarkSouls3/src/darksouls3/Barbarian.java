/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Barbarian extends Character{
    
    public Barbarian(int mana, int stamina, String name, int life, int baseAtt) {
        super(mana, stamina, name, life, baseAtt);
    }


    @Override
    //modalità berserk
    public void specialAbility(Villain v) {
        
        if(this.getLife() <= 10){
            v.setLife(0);
        }
        this.setMana(this.getMana() - this.getMana()/5);
    }
    @Override
    public String toString(){
        return "\"Berserk Mode\"\n" +
    "\"When the Barbarian stands at death's door, fury consumes all reason.\n" +
    "With but a breath of life remaining, the foe is struck down utterly,\n" +
    "as if destiny itself wills their annihilation. The body fights for survival,\n" +
    "and the enemy falls before the wrath of the chosen warrior.\"\n\n" +
    "Effect:\n" +
    "  If life <= 10, enemy instantly reduced to 0 Life";
    }
}
