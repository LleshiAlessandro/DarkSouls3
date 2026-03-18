/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.Random;

/**
 *
 * @author aless
 */
public class FightManager {
    private int turni;
    private String[] keyWords = {"heal", "attack", "roll"};
    private Random escape;
    int escapeResult;

    public FightManager() {
        this.turni = 1;
    }
    
    public void incrementTurn(){
        turni = turni + 1;
    }
    
    //controlla di chi è il turno, nel gestore dovrò gestire cosa succede nel turno del giocatore e del boss
    public boolean chooseTurn(Character c, Villain v){
        if(c.getLife() > 0 && v.getLife() > 0){
            
            //turni del character
            if(turni %2 != 0){
                this.incrementTurn();
                return true;
            }
            //turni del nemico
            else{
                this.incrementTurn();
                return false;
            }
        }
        return false;
    }
    
    public void fightManaged(Character c, Villain v, String keyWord){
        this.chooseTurn(c, v);
        if(keyWord.equals(keyWords[0])){
            c.useEstus();
        }
        else if(keyWord.equals(keyWords[1])){
            v.setLife(v.life = v.life - 20);
        }
        else if(keyWord.equals(keyWords[2])){
            escape = new Random();
            escapeResult = escape.nextInt(0, 6);
            if(escapeResult == 0){
                c.setLife(c.life = c.life - v.baseAtt);
            }
            else{
                c.stamina -= 10;
                c.setLife(c.life = c.life + 10);
            }
        }
        else{
            System.out.println(" Errore ");
        }
    }
    //nel form del fight dovrò inserire in ogni pulsante la sua kewWord
}
