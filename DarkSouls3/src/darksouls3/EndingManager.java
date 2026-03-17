/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;


/**
 *
 * @author aless
 */
public class EndingManager {
    private NPC npc = new NPC();
    
    public Ending ending(){
        for(NPC_Name n: npc.getNPC_Name()){
            if(n.equals(NPC_Name.ANRI_OF_ASTORA) || n.equals(NPC_Name.YURIA_OF_LONDOR) || n.equals(NPC_Name.YOEL_OF_LONDOR)){
                return Ending.BAD_ENDING;
            }
            else if(n.equals(NPC_Name.FIRE_KEEPER)){
                return Ending.GOOD_ENDING;
            }
        }
        return Ending.CLASSIC_ENDING;
    }
}
