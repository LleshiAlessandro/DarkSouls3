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
    private Ending e;
    private NPC npc = new NPC();
    private NPC particularNPC_ForEnding = new NPC();
    
    public Ending ending(){
        for(NPC_Name n: npc.getNPC_Name()){
            if(n.equals(n.ANRI_OF_ASTORA) || n.equals(n.YURIA_OF_LONDOR) || n.equals(n.YOEL_OF_LONDOR)){
                return e.BAD_ENDING;
            }
            else if(n.equals(n.FIRE_KEEPER)){
                return e.GOOD_ENDING;
            }
        }
        return e.CLASSIC_ENDING;
    }
}
