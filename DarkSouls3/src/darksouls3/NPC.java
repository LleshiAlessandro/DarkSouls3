/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;


/**
 *
 * @author aless
 */
public class NPC {
    private NPC_Name[] npcs;
        
    public NPC_Name[] getNPC_Name(){
        for(NPC_Name n: NPC_Name.values()){
            for(int i = 0; i <  NPC_Name.values().length; i++){
                npcs[i] = NPC_Name.values()[i];
            }
        }
        return npcs;
    }
}
