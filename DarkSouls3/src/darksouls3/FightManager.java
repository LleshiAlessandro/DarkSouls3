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
    protected int turni;
    private String[] keyWords = {"heal", "attack", "roll", "ability"};
    private Random escape;
    private int escapeResult;
    

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
        boolean turn = this.chooseTurn(c, v);
        if(turn == true){
            if(keyWord.equals(keyWords[0])){
                c.useEstus();
            }
            else if(keyWord.equals(keyWords[1])){
                v.setLife(v.life = v.life - c.baseAtt);
            }
            else if(keyWord.equals(keyWords[2])){
                escape = new Random();
                escapeResult = escape.nextInt(0, 101);
                if(escapeResult <= 33){
                    c.setLife(c.life = c.life - v.baseAtt);
                    c.stamina -= 10;
                }
                else{
                    c.stamina -= 10;
                    c.setLife(c.life = c.life + 15);
                }
            }
            else if(keyWord.equals(keyWords[3])){
                c.specialAbility(v);
            }
            else{
                System.out.println(" Errore ");
            }
                    
            if(fightResult(c, v) != -1){
                return; // blocca il turno del boss
            }
        }
        else{
            if(v.getLife() > 0){
                c.setLife(c.life = c.life - v.getBaseAtt());
            }
        }
    }
    public int fightResult(Character c, Villain v){
    if (c.getLife() <= 0 && v.getLife() <= 0) {
                return 0;//fight pareggiato
            }
            else if (c.getLife() <= 0) {
                return 1;//fight vinto dal boss
                
            }
            else if (v.getLife() <= 0) {
                return 2;//fight vinto
            }
        return -1;
    }
    public int getTurni() {
        return turni;
    }
    
}
