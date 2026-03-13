/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class NPC {
    private ArrayList<NPC_Name> npcs = new ArrayList();
        
    public ArrayList<NPC_Name> getNPC_Name(){
        for(NPC_Name n: NPC_Name.values()){
            npcs.add(n);
        }
        return npcs;
    }
}
