/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author aless
 */
public class FightManager {
    private int turni;

    public FightManager() {
        this.turni = 1;
    }
    
    public void incrementTurn(){
        turni = turni + 1;
    }
    
    //controlla di chi è il turno, nel gestore dovrò gestire cosa succede nel turno del giocatore e del boss
    public boolean fight(Character c, Villain v){
        if(c.getLife() > 0 && v.getLife() > 0){
            
            //turni del character
            if(turni %2 != 0){
                this.incrementTurn();
                return true;
            }
            //turni del nemico
            else{
                //c.setLife(c.life = c.life - 33);
                this.incrementTurn();
                return false;
            }
        }
        return false;
    }
}
